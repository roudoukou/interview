package icu.xiamu.singleton;

/**
 * @author roudoukou
 * @date 2025/5/23
 */
public class Person {
    // 饿汉式
/*
    private Person() {

    }

    private static final Person person = new Person();

    public static Person getInstance() {
        return person;
    }
*/

    // 懒汉式
    // 1. 类锁 synchronized
/*
    private Person() {

    }

    private static Person instance = null;

    public static synchronized Person getInstance() {
        if (instance == null) {
            instance = new Person();
        }
        return instance;
    }
*/

    // 懒汉式
    private Person() {

    }

    private static volatile Person instance = null;

    public static Person getInstance() {
        if (instance == null) {
            synchronized (Person.class) {
                if (instance == null) {
                    instance = new Person();
                }
            }
        }

        return instance;
    }


}
