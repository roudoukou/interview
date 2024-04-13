package icu.xiamu.juc.cf;

import java.util.concurrent.CompletableFuture;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/13
 */
public class CompletableFutureAPI3Demo {
    public static void main(String[] args) {
        // demo1();

        // null
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenRun(() -> {}).join());

        // resultA
        // null
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenAccept(r -> System.out.println(r)).join());

        // resultAresultB
        System.out.println(CompletableFuture.supplyAsync(() -> "resultA").thenApply(r -> r + "resultB").join());
    }

    private static void demo1() {
        CompletableFuture.supplyAsync(() -> {
            return 1;
        }).thenApply(f -> {
            return f + 2;
        }).thenApply(f -> {
            return f + 3;
        }).thenAccept(r -> {
            System.out.println(r);
        });
    }
}
