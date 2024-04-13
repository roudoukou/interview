package icu.xiamu.juc.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/13
 */
public class CompletableFutureAPIDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "abc";
        });

        // abc
        // System.out.println(completableFuture.get());

        // 未超时: abc
        // 超时:   java.util.concurrent.TimeoutException
        // System.out.println(completableFuture.get(2L, TimeUnit.SECONDS));

        // abc
        // System.out.println(completableFuture.join());

        // 任务没有完成直接返回 : "黄磊不帅"
        // 任务完成之后返回: "abc"
        // try {
        //     TimeUnit.SECONDS.sleep(2);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        // System.out.println(completableFuture.getNow("黄磊不帅"));

        // 是否被打断,
        // 已经算出结果了, 没有打断   => false abc
        // 还没有结果, 打断了 , 直接要结果 => true completeValue
        TimeUnit.SECONDS.sleep(1);
        System.out.println(completableFuture.complete("completeValue") + "\t" + completableFuture.join());
    }
}
