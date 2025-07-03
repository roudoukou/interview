package icu.xiamu.year2023.shuzimali;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/15
 */
public class Demo2 {
    public static void main(String[] args) {
        // 已知餐馆有n道菜, 第i到菜售价为wi, 小红准备点一些价格相同的菜, 但小红不会点单价超过m的菜, 她想知道最多可以点多少道菜
        // n菜品数量, m最大单价
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = in.nextInt();
            }
            System.out.println(process(n, m, nums));
        }
    }

    private static int process(int n, int m, int[] prices) {
        int maxCount = 0;
        HashMap<Integer, Integer> priceCounts = new HashMap<>();
        for (int price : prices) {
            if (priceCounts.containsKey(price)) {
                priceCounts.put(price, priceCounts.get(price) + 1);
            } else {
                priceCounts.put(price, 1);
            }
        }

        for (Integer price : priceCounts.keySet()) {
            maxCount += Math.min(Math.floorDiv(m, price), priceCounts.get(price));
        }

        return maxCount;
    }
}
