package icu.xiamu.juc.cf;

import java.util.concurrent.*;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/13
 */
public class CompletableFutureUseDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // demo1();
        // 运行结果:
        /*
        main线程先去忙其它任务
        ForkJoinPool.commonPool-worker-1come in
        一秒后出结果: 1
        1
         */

        // whenComplete + 默认线程池
        // demo2();
        // 运行结果:
        /*
        ForkJoinPool.commonPool-worker-1 come in
        main线程先去忙其它任务
        一秒后出结果: 3
        计算完成, 更新系统UpdateValue3
         */

        // whenComplete + 自定义的线程池
        demo3();

        // 运行结果
        /*
        pool-1-thread-1 come in
        main线程先去忙其它任务
        一秒后出结果: 5
        计算完成, 更新系统UpdateValue5
        */
        // 演示出错
        /*
        pool-1-thread-1 come in
        main线程先去忙其它任务
        一秒后出结果: 4
        异常情况: java.lang.ArithmeticException: / by zero	java.lang.ArithmeticException: / by zero
        java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
            at java.util.concurrent.CompletableFuture.encodeThrowable(CompletableFuture.java:273)
            at java.util.concurrent.CompletableFuture.completeThrowable(CompletableFuture.java:280)
            at java.util.concurrent.CompletableFuture$AsyncSupply.run(CompletableFuture.java:1592)
            at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
            at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
            at java.lang.Thread.run(Thread.java:748)
        Caused by: java.lang.ArithmeticException: / by zero
            at icu.xiamu.juc.cf.CompletableFutureUseDemo.lambda$demo3$0(CompletableFutureUseDemo.java:48)
            at java.util.concurrent.CompletableFuture$AsyncSupply.run(CompletableFuture.java:1590)
            ... 3 more
         */
    }

    private static void demo3() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + " come in");
                int result = ThreadLocalRandom.current().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("一秒后出结果: " + result);

                // 演示出错场景
                // int i = 10/0;
                return result;
            }, threadPool).whenComplete((v, e) -> {
                if (e == null) {
                    System.out.println("计算完成, 更新系统UpdateValue" + v);
                }
            }).exceptionally(e -> {
                e.printStackTrace();
                System.out.println("异常情况: " + e.getCause() + "\t" + e.getMessage());
                return null;
            });
            System.out.println(Thread.currentThread().getName() + "线程先去忙其它任务");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 养成关闭线程池的好习惯
            threadPool.shutdown();
        }

        // 解释下为什么默认线程池关闭, 自定义线程池记得关闭
        // 主线程不要立刻结束, 否则 CompletableFuture 默认使用线程池会立刻关闭, 暂停3秒钟线程
        // 使用了自定义的线程池, 所以可以不用睡眠了
    }

    private static void demo2() {

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("一秒后出结果: " + result);
            return result;
        }).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("计算完成, 更新系统UpdateValue" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println("异常情况: " + e.getCause() + "\t" + e.getMessage());
            return null;
        });
        System.out.println(Thread.currentThread().getName() + "线程先去忙其它任务");

        // 解释下为什么默认线程池关闭, 自定义线程池记得关闭
        // 主线程不要立刻结束, 否则 CompletableFuture 默认使用线程池会立刻关闭, 暂停3秒钟线程
        // try {
        //     TimeUnit.SECONDS.sleep(3);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
    }

    private static void demo1() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("一秒后出结果: " + result);
            return result;
        });

        System.out.println(Thread.currentThread().getName() + "线程先去忙其它任务");
        System.out.println(completableFuture.get());
    }
}
