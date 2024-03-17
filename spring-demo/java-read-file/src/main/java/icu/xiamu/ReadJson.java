package icu.xiamu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 肉豆蔻吖
 * @date 2024/3/16
 * 参考文章: <a href="https://xie.infoq.cn/article/073c980d081cea570dcad8073">...</a>
 */
public class ReadJson {
    public static void main(String[] args) {
        // 1.借助FileReader BufferedReader
        // demo1();

        // 2.nio
        demo2();

        // 3.借助第三方工具 jackson
        // demo3();
    }

    private static void demo1() {
        File file = new File("E:\\Code\\面试题\\spring-demo\\java-read-file\\src\\main\\resources\\data.json");
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sb.toString());

    }

    private static void demo2() {
        Path path = Paths.get("E:\\Code\\面试题\\spring-demo\\java-read-file\\src\\main\\resources\\data.json");
        try {
            byte[] bytes = Files.readAllBytes(path);
            String json = new String(bytes, StandardCharsets.UTF_8); // Charset.forName("UTF-8")
            System.out.println(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void demo3() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Object o = objectMapper.readValue(new File("spring-demo/java-read-file/src/main/resources/data.json"), Object.class);
            String json = objectMapper.writeValueAsString(o);
            System.out.println("json = " + json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
