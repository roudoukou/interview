package icu.xiamu.juc.cf;

import java.util.concurrent.*;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/13
 */
public class CompletableFutureBuildDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // runAsync()使用默认的线程池
        // demo1();

        // runAsync()使用自己定义的线程池
        // demo2();

        // supplyAsync()使用默认线程池
        // demo3();

        // supplyAsync()使用自定义线程池
        demo4();
    }

    private static void demo4() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            // pool-1-thread-1
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello SupplyAsync";
        }, threadPool);
        // Hello SupplyAsync
        System.out.println(completableFuture.get());
    }

    private static void demo3() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            // ForkJoinPool.commonPool-worker-1
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return "Hello SupplyAsync";
        });

        // Hello SupplyAsync
        System.out.println(completableFuture.get());
    }

    private static void demo2() throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            // pool-1-thread-1
            System.out.println(Thread.currentThread().getName());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, threadPool);

        // null
        System.out.println(completableFuture.get());

        // 养成关闭线程池的好习惯
        threadPool.shutdown();
    }

    private static void demo1() throws InterruptedException, ExecutionException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            // ForkJoinPool.commonPool-worker-1
            System.out.println(Thread.currentThread().getName());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // null
        System.out.println(completableFuture.get());
    }
}
