package icu.xiamu.juc.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/13
 */
public class CompletableFutureAPI2Demo {
    public static void main(String[] args) {

        thenApply();
        // 运行结果
        /*
        main主线程先去忙其它任务
        111
        222
        333
        计算结果6

        main主线程先去忙其它任务
        111
        java.lang.ArithmeticException: / by zero
        java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
         */

        // handle();
        // 运行结果
        /*
        main主线程先去忙其它任务
        111
        222
        333
        计算结果6

        main主线程先去忙其它任务
        111
        333
        java.lang.NullPointerException
        java.util.concurrent.CompletionException: java.lang.NullPointerException
         */
    }

    private static void handle() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("111");
            return 1;
        }, threadPool).handle((f, e) -> {
            // int i = 1 / 0;
            System.out.println("222");
            return f + 2;
        }).handle((f, e) -> {
            System.out.println("333");
            return f + 3;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("计算结果" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });
        System.out.println(Thread.currentThread().getName() + "主线程先去忙其它任务");
        threadPool.shutdown();
    }

    private static void thenApply() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() -> {
            // 暂停几秒钟线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("111");
            return 1;
        }, threadPool).thenApply(f -> {
            int i = 1 / 0;
            System.out.println("222");
            return f + 2;
        }).thenApply(f -> {
            System.out.println("333");
            return f + 3;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("计算结果" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        });

        System.out.println(Thread.currentThread().getName() + "主线程先去忙其它任务");

        // 养成关闭线程池的好习惯
        threadPool.shutdown();
    }
}
