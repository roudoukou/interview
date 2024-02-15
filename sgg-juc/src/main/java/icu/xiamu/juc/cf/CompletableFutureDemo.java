package icu.xiamu.juc.cf;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread2());
        Thread t1 = new Thread(futureTask);
        t1.start();

        // get返回值
        System.out.println(futureTask.get());
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("--------come in");
        return "hello Callable";
    }
}
