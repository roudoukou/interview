package icu.xiamu;

import com.alibaba.fastjson2.*;
import icu.xiamu.entity.Pig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Base64;
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

    @Test
    void test9() {
        class User {
            public int id;
            public String name;
        }

        User user = new User();
        user.id = 2;
        user.name = "FastJson2";

        String text = JSON.toJSONString(user);
        byte[] bytes = JSON.toJSONBytes(user);

        System.out.println(text);
        System.out.println(new String(bytes));
    }

    @Test
    void test10() {
        class User {
            public int id;
            public String name;
        }

        User user = new User();
        user.id = 2;
        user.name = "FastJson2";

        // {"id":2,"name":"FastJson2"}
        byte[] bytes1 = JSONB.toBytes(user);
        // [2,"FastJson2"]
        byte[] bytes2 = JSONB.toBytes(user, JSONWriter.Feature.BeanToArray);

        JSONObject jsonObject = JSONB.parseObject(bytes1);
        System.out.println(jsonObject);
        JSONArray jsonArray = JSONB.parseArray(bytes2);
        System.out.println(jsonArray);

        User user1 = JSONB.parseObject(bytes1, User.class);
        // 注意不是byte2
        User user2 = JSONB.parseObject(bytes1, User.class, JSONReader.Feature.SupportArrayToBean);
        System.out.println(user1.id + "," + user1.name);
        System.out.println(user2.id + "," + user2.name);
    }

    @Test
    void test11() {
        String text = "{\n" +
                "    \"id\": 111\n" +
                "}";
        JSONPath path = JSONPath.of("$.id");
        JSONReader reader = JSONReader.of(text);
        Object result = path.extract(reader);
        System.out.println(result);

        // byte[] bytes = ...;
        // JSONPath path = JSONPath.of("$.id"); // 缓存起来重复使用能提升性能
        //
        // JSONReader parser = JSONReader.of(bytes);
        // Object result = path.extract(parser);

        // byte[] bytes = ...;
        // JSONPath path = JSONPath.of("$.id"); // 缓存起来重复使用能提升性能
        //
        // JSONReader parser = JSONReader.ofJSONB(bytes); // 注意这里使用ofJSONB方法
        // Object result = path.extract(parser);
    }






}
