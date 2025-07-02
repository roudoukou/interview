package icu.xiamu.singleton;

/**
 * @author roudoukou
 * @date 2025/5/23
 */
public class MainTest {
    public static void main(String[] args) {
        Person person1 = Person.getInstance();
        Person person2 = Person.getInstance();
        System.out.println(person1 == person2);
    }
}
