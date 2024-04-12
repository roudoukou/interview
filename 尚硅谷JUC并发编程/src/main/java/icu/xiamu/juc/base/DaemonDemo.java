package icu.xiamu.juc.base;

import java.util.concurrent.TimeUnit;

public class DaemonDemo {
    public static void main(String[] args) { // 一切方法运行的入口
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 开始运行，" + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));
            while (true) {
            }
        }, "t1");

        /*
        // 默认t1.setDaemon(false);
        // 运行结果:
        t1	 开始运行，用户线程
        ----------main线程运行完毕
         */
        t1.setDaemon(true);
        /*
        // t1.setDaemon(true);
        // 运行结果:
        t1	 开始运行，守护线程
        ----------main线程运行完毕
         */
        t1.start();

        // 3秒钟后主线程再运行
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("----------main线程运行完毕");
    }
}
