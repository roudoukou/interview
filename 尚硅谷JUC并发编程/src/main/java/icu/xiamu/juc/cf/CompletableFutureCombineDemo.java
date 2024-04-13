package icu.xiamu.juc.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/13
 */
public class CompletableFutureCombineDemo {
    public static void main(String[] args) {
        // 标准版
        // demo1();

        // 链式表达式
        demo2();
    }

    private static void demo2() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 20;
        }), (x, y) -> {
            System.out.println("开始两个结果合并");
            return x + y;
        });

        System.out.println(completableFuture.join());
        // ForkJoinPool.commonPool-worker-1启动
        // ForkJoinPool.commonPool-worker-2启动
        // 开始两个结果合并
        // 30
    }

    private static void demo1() {
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10;
        });

        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 20;
        });

        CompletableFuture<Integer> result = completableFuture1.thenCombine(completableFuture2, (x, y) -> {
            System.out.println("开始两个结果合并");
            return x + y;
        });

        System.out.println(result.join());

        // ForkJoinPool.commonPool-worker-1启动
        // ForkJoinPool.commonPool-worker-2启动
        // 开始两个结果合并
        // 30
    }
}
