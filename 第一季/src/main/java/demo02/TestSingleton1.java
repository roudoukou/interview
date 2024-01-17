package demo02;

/**
 * 测试第一个 直接创建实例对象
 */
public class TestSingleton1 {
    public static void main(String[] args) {
        Singleton1 s = Singleton1.INSTANCE;
        System.out.println(s);
    }
}
