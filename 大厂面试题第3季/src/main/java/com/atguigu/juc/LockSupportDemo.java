package com.atguigu.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {
    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "\t come in\t" + System.currentTimeMillis());
            // sleep方法3秒后醒来, 执行park无效, 没有阻塞效果, 解释如下
            // 先执行了unpark(t1)导致上面park方法形同虚设无效, 时间一样
            LockSupport.park();
            // LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t 被唤醒\t" + System.currentTimeMillis());
        }, "t1");
        t1.start();

        // try {
        //     TimeUnit.SECONDS.sleep(3L);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 通知");
            LockSupport.unpark(t1);
            // LockSupport.unpark(t1); 最多解开一个park, 因为permit最大值就是1, 调用多次都是1
        }, "t2");
        t2.start();


        // lockAwaitSignal();

        // synchronizedWaitNotify();
    }

    private static void lockAwaitSignal() {
        new Thread(() -> {
            // try {
            //     TimeUnit.SECONDS.sleep(3L);
            // } catch (InterruptedException e) {
            //     throw new RuntimeException(e);
            // }

            lock.lock();
            try {
                // 必须在同步代码块中, 否则 java.lang.IllegalMonitorStateException
                System.out.println(Thread.currentThread().getName() + "\t come in");
                try {
                    condition.await(); // 必须先await了才能signal
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "\t 被唤醒");
            } finally {
                lock.unlock();
            }
        }, "A").start();

        new Thread(() -> {
            lock.lock();
            try {
                // 必须在同步代码块中, 否则 java.lang.IllegalMonitorStateException
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t 通知");
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }

    private static void synchronizedWaitNotify() {
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
                System.out.println(Thread.currentThread().getName() + "\t 通知");
            }
        }, "B").start();
    }
}
