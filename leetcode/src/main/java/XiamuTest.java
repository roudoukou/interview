package main.java;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XiamuTest {
    public static void main(String[] args) {
        Map<String, String> map = Stream.of(new String[][] {
                {"a", "b"},
                {"b", "c"}
        }).collect(Collectors.toMap(k -> k[0], v -> v[1]));

        String key = "a";
        String orDefault = map.getOrDefault(key, key);
        System.out.println(orDefault);

    }
}
