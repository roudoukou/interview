package icu.xiamu;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 肉豆蔻吖
 * @date 2024/5/3
 */
public class MarkdownParser {
    public static void main(String[] args) {
        // 请将此路径替换为实际文件路径
        String filename = "E:\\Code\\Blog\\hexo-blog\\source\\_posts\\深圳\\账本.md";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String dateTime = "";
            Map<String, List<Map<String, String>>> transactionsMap = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("##")) {
                    // 提取完整的日期和时间部分
                    dateTime = line.substring(3);
                    transactionsMap.put(dateTime, new ArrayList<>());
                } else if (line.startsWith("- **")) {
                    String[] parts = line.split("\\*\\*");
                    String label = parts[1].trim();
                    String descriptionWithAmount = parts[2].trim();

                    // 将描述拆分为单词数组
                    String[] descParts = descriptionWithAmount.split(" ");
                    // 提取除了最后一个单词（金额）之外的部分作为描述
                    StringBuilder descriptionBuilder = new StringBuilder();
                    for (int i = 0; i < descParts.length - 1; i++) {
                        descriptionBuilder.append(descParts[i]).append(" ");
                    }
                    String description = descriptionBuilder.toString().trim();

                    // 最后一个单词是金额
                    String price = descParts[descParts.length - 1];

                    // 将每条交易记录保存到 Map 中
                    Map<String, String> transaction = new HashMap<>();
                    transaction.put("label", label);
                    transaction.put("description", description);
                    transaction.put("price", price);

                    transactionsMap.get(dateTime).add(transaction);
                }
            }

            // 使用 GSON 将 Map 转换为 JSON 字符串
            Gson gson = new Gson();
            String jsonOutput = gson.toJson(transactionsMap);

            // 打印 JSON 输出
            System.out.println(jsonOutput);

            // 统计不同日期数和消费记录数
            int days = transactionsMap.size();
            int transactionsCount = transactionsMap.values().stream()
                    .mapToInt(List::size)
                    .sum();

            // 打印统计结果
            System.out.println("记录了 " + days + " 天。");
            System.out.println("共消费了 " + transactionsCount + " 次。");

            Map<String, BigDecimal> labelSums = transactionsMap.values().stream()
                    // 扁平化成单个交易的 Stream
                    .flatMap(List::stream)
                    .collect(Collectors.groupingBy(
                            // 按标签分组
                            transaction -> transaction.get("label"),
                            // 计算总价格
                            // Collectors.summingDouble(transaction -> Double.parseDouble(transaction.get("price")))
                            Collectors.reducing(BigDecimal.ZERO,
                                    transaction -> new BigDecimal(transaction.get("price")),
                                    BigDecimal::add)
                    ));

            // 打印每个标签的总金额
            labelSums.forEach((label, sum) -> System.out.println(label + ": " + sum));

            double totalSum = transactionsMap.values().stream()
                    .flatMap(List::stream)
                    .mapToDouble(transaction -> Double.parseDouble(transaction.get("price")))
                    .sum();
            System.out.println("总消费 = " + totalSum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
