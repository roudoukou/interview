package com.atguigu.juc;

/**
 * 可重入锁: 可重复可递归调用的锁, 在外层使用锁之后, 在内层任然可以使用, 并且不发生死锁, 这样的锁就叫做可重入锁
 *
 * 在一个synchronized修饰的方法或代码块的内部
 * 调用本类的其他synchronized修饰的方法或代码块, 是永远可以得到锁的
 */
public class ReEnterLockDemo {

/*
    // 可重入锁-synchronized-同步代码块
    static Object objectLockA = new Object();
    public static void m1() {
        new Thread(() -> {
            synchronized (objectLockA) {
                System.out.println(Thread.currentThread().getName() + "\t外层调用");
                synchronized (objectLockA) {
                    System.out.println(Thread.currentThread().getName() + "\t中层调用");
                    synchronized (objectLockA) {
                        System.out.println(Thread.currentThread().getName() + "\t内层调用");
                    }
                }
            }
        }, "t1").start();
    }
*/

    // 可重入锁-synchronized-同步方法
    private synchronized static void m1() {
        System.out.println("外层");
        m2();
    }

    private synchronized static void m2() {
        System.out.println("中层");
        m3();
    }

    private synchronized static void m3() {
        System.out.println("内层");
    }

    public static void main(String[] args) {
        m1();
    }
}
