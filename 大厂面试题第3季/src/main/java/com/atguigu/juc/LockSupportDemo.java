package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportDemo {
    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {

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

        // synchronizedWaitNotify();
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
