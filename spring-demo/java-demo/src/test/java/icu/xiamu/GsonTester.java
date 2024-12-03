package icu.xiamu;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import icu.xiamu.entity.Student;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * doc: https://www.tutorialspoint.com/gson/gson_quick_guide.htm
 * https://github.com/apachecn/zetcode-zh/blob/master/docs/java/39.md
 */
public class GsonTester {

    @Test
    void test1() {
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        Student student = gson.fromJson(jsonString, Student.class);
        System.out.println(student);

        gson.toJson(student);
    }

    @Test
    void test2() {
        Map<Integer, String> colours = new HashMap<>();
        colours.put(1, "blue");
        colours.put(2, "yellow");
        colours.put(3, "green");

        Gson gson = new Gson();
        String json = gson.toJson(colours);
        System.out.println(json);
    }

    class User {

        private final String firstName;
        private final String lastName;

        public User(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return new StringBuilder().append("User{").append("First name: ")
                    .append(firstName).append(", Last name: ")
                    .append(lastName).append("}").toString();
        }
    }

    @Test
    void test3() {
        String json_string = "{\"firstName\":\"Tom\", \"lastName\": \"Broody\"}";

        Gson gson = new Gson();
        User user = gson.fromJson(json_string, User.class);
        System.out.println(user);
    }

    @Test
    void test4() {
        try (PrintStream prs = new PrintStream(System.out, true, "UTF8")) {
            Gson gson = new GsonBuilder()
                    // key 首字母大写
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            User user = new User("Peter", "Flemming");
            gson.toJson(user, prs);

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Test
    void test5() {
        Map<String, Integer> items = new HashMap<>();

        items.put("chair", 3);
        items.put("pencil", 1);
        items.put("book", 5);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(items, System.out);

        String json = gson.toJson(items);
        System.out.println(json);
    }
}
