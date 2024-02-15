package icu.xiamu.juc.cf;

import java.util.concurrent.*;

public class FutureThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 3个任务, 目前只有一个线程main来处理, 请问耗时多少?
        // 运行结果
        /*
        ---constTime: 1128 毫秒
        main	 ---end
         */
        // m1();

        // 3个任务, 目前开启多个异步任务线程来处理, 请问耗时多少?
        // 运行结果
        /*
        ---constTime: 387 毫秒
        main	 ---end
         */
        // m2();

        // 3个任务, 目前开启多个异步任务线程来处理, 并且接收子线程返回值, 请问耗时多少?
        // 运行结果
        /*
        task1 over
        task2 over
        ---constTime: 901 毫秒
        main	 ---end
         */
        m3();
    }

    private static void m3() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        long startTime = System.currentTimeMillis();

        FutureTask<String> futureTask1 = new FutureTask<>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task1 over";
        });
        threadPool.submit(futureTask1);

        FutureTask<String > futureTask2 = new FutureTask<>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task2 over";
        });
        threadPool.submit(futureTask2);

        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("---constTime: " + (endTime - startTime) + " 毫秒");

        System.out.println(Thread.currentThread().getName() + "\t ---end");
        // 关闭资源
        threadPool.shutdown();
    }

    private static void m2() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        long startTime = System.currentTimeMillis();

        FutureTask<String> futureTask1 = new FutureTask<>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task1 over";
        });
        threadPool.submit(futureTask1);

        FutureTask<String > futureTask2 = new FutureTask<>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task2 over";
        });
        threadPool.submit(futureTask2);

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("---constTime: " + (endTime - startTime) + " 毫秒");

        System.out.println(Thread.currentThread().getName() + "\t ---end");
        // 关闭资源
        threadPool.shutdown();
    }

    private static void m1() {
        long startTime = System.currentTimeMillis();
        // 暂停毫秒
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("---constTime: " + (endTime - startTime) + " 毫秒");

        System.out.println(Thread.currentThread().getName() + "\t ---end");
    }
}
