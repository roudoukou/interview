package com.atguigu.juc;

public class LockSupportDemo {
    static Object objectLock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (objectLock) { // 必须在同步代码块中, 否则 java.lang.IllegalMonitorStateException
                System.out.println(Thread.currentThread().getName() + "\t come in");
                try {
                    objectLock.wait(); // 必须先wait了才能notify
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "\t 被唤醒");
            }
        }, "A").start();
        new Thread(() -> {
            synchronized (objectLock) { // 必须在同步代码块中, 否则 java.lang.IllegalMonitorStateException
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t通知");
            }
        }, "B").start();
    }
}
