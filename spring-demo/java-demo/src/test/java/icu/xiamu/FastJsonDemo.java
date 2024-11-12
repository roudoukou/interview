package icu.xiamu;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import icu.xiamu.entity.Pig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * doc: https://alibaba.github.io/fastjson2/
 */
@SpringBootTest
public class FastJsonDemo {
    @Test
    public void test1() {
        String text = "{\n" +
                "    \"name\": \"peiqi\",\n" +
                "    \"age\": 18\n" +
                "}";
        JSONObject data = JSON.parseObject(text);
        System.out.println(data);

        byte[] bytes = text.getBytes();
        JSONObject data1 = JSON.parseObject(bytes);
        System.out.println(data1);
    }

    @Test
    void test2() {
        String text = "[\n" +
                "    {\n" +
                "        \"name\": \"peiqi\",\n" +
                "        \"age\": 18\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"qiaozhi\",\n" +
                "        \"age\": 22\n" +
                "    }\n" +
                "]";

        JSONArray jsonArray = JSON.parseArray(text);
        System.out.println(jsonArray);
    }

    @Test
    void test3() {
        String text = "{\n" +
                "        \"name\": \"qiaozhi\",\n" +
                "        \"age\": 22\n" +
                "    }";
        Pig pig = JSON.parseObject(text, Pig.class);
        System.out.println(pig);
    }

    @Test
    void test4() {
        Pig pig = new Pig();
        pig.setAge(10);
        pig.setName("xiaohuang");

        String jsonString = JSON.toJSONString(pig);
        byte[] jsonBytes = JSON.toJSONBytes(pig);
        System.out.println(jsonString);
        System.out.println(new String(jsonBytes));
    }

    @Test
    void test5() {
        String text = "{\"id\": 2,\"name\": \"fastjson2\"}";
        JSONObject obj = JSON.parseObject(text);

        int id = obj.getIntValue("id");
        String name = obj.getString("name");
        System.out.println(id);
        System.out.println(name);
    }

    @Test
    void test6() {
        String text = "[2, \"fastjson2\"]";
        JSONArray array = JSON.parseArray(text);

        int id = array.getIntValue(0);
        String name = array.getString(1);
        System.out.println(id);
        System.out.println(name);
        System.out.println(array.get(0));
        System.out.println(array.get(1));
    }

    @Test
    void test07() {
        // JSON 数据字符串
        String jsonArrayString = "[{\"name\": \"Babe\", \"age\": 3}, {\"name\": \"Wilbur\", \"age\": 2}]";
        String jsonObjectString = "{\"key\": {\"name\": \"Piglet\", \"age\": 1}}";

        // 将 JSON 字符串解析为 JSONArray 和 JSONObject
        JSONArray array = JSON.parseArray(jsonArrayString);
        JSONObject obj = JSON.parseObject(jsonObjectString);

        // 从 JSONArray 中解析第一个元素为 Pig 对象
        Pig pigFromArray = array.getObject(0, Pig.class);
        System.out.println("Pig from array: " + pigFromArray);

        // 从 JSONObject 中解析 "key" 对应的值为 Pig 对象
        Pig pigFromObject = obj.getObject("key", Pig.class);
        System.out.println("Pig from object: " + pigFromObject);
    }

    @Test
    void test8() {
        String jsonArrayString = "[{\"name\": \"Babe\", \"age\": 3}, {\"name\": \"Wilbur\", \"age\": 2}]";
        String jsonObjectString = "{\"key\": {\"name\": \"Piglet\", \"age\": 1}}";

        JSONArray array = JSON.parseArray(jsonArrayString);
        JSONObject obj = JSON.parseObject(jsonObjectString);

        Pig pig = obj.getObject("key", Pig.class);
        System.out.println(pig);
        List<Pig> users = array.toJavaList(Pig.class);
        System.out.println(users);
    }
}
