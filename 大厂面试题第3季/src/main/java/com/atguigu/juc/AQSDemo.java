package com.atguigu.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        // 带入一个银行办理业务的案例来模拟我们的AQS如何进行线程的管理和通知唤醒机制

        // 3个线程模拟3个银行网点, 受理窗口办理业务的顾客

        // A 顾客就是第一个顾客, 此时手里窗口没有任何人, A可以直接去办理
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t come in");
                try {
                    TimeUnit.MINUTES.sleep(3L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                lock.unlock();
            }
        }, "A").start();

        // 第2个顾客, 第2个线程 由于受理业务的窗口只有一个(只能一个线程持有锁), 此时B只能等待
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t come in");
                try {
                    TimeUnit.MINUTES.sleep(3L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                lock.unlock();
            }
        }, "B").start();

        // 第3个顾客, 第3个线程 由于受理业务的窗口只有一个(只能一个线程持有锁), 此时C只能等待
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t come in");
                try {
                    TimeUnit.MINUTES.sleep(3L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                lock.lock();
            }
        }, "C").start();
    }
}
