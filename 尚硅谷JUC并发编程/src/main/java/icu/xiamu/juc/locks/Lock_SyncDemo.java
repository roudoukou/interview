package icu.xiamu.juc.locks;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/26
 */
public class Lock_SyncDemo {
    private final Object object = new Object();

    public void m1() {
        synchronized (object) {
            System.out.println("hello synchronized code block");
        }
    }

    public static void main(String[] args) {

    }
}
