package icu.xiamu.juc.cf;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureAPIDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            TimeUnit.SECONDS.sleep(5);
            return "task over";
        });

        Thread t1 = new Thread(futureTask);
        t1.start();

        // System.out.println(futureTask.get()); // 2.阻塞main线程
        // System.out.println(futureTask.get(3, TimeUnit.SECONDS)); // 3.设置阻塞超时时间
        System.out.println(Thread.currentThread().getName() + "\t 忙其他任务了");
        // System.out.println(futureTask.get()); // 1.不阻塞main线程

        // 4.通过轮询方式获取结果
        while (true) {
            if (futureTask.isDone()) {
                System.out.println(futureTask.get());
                break;
            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("正在处理中, 不要催了, 越催越慢, 再催熄火");
            }
        }
    }
}


/*
// 运行结果
// 2.阻塞main线程
Thread-0	 come in
task over
main	 忙其他任务了

// 3.设置阻塞超时时间
Thread-0	 come in
Exception in thread "main" java.util.concurrent.TimeoutException
	at java.util.concurrent.FutureTask.get(FutureTask.java:205)
	at icu.xiamu.juc.cf.FutureAPIDemo.main(FutureAPIDemo.java:20)

// 1.不阻塞main线程
main	 忙其他任务了
Thread-0	 come in
task over

总结: System.out.println(futureTask.get());
1. get 容易导致阻寒，一般建议放在程序后面，一旦调用不见不做，非要等到结果才会离开，不管你是否计算完成，容易程序堵寒
2. 假如我不愿意等待很长时间，我希望过时不候，可以自动离开.

// 4.通过轮询方式获取结果
main	 忙其他任务了
Thread-0	 come in
正在处理中, 不要催了, 越催越慢, 再催熄火
正在处理中, 不要催了, 越催越慢, 再催熄火
正在处理中, 不要催了, 越催越慢, 再催熄火
正在处理中, 不要催了, 越催越慢, 再催熄火
正在处理中, 不要催了, 越催越慢, 再催熄火
正在处理中, 不要催了, 越催越慢, 再催熄火
正在处理中, 不要催了, 越催越慢, 再催熄火
正在处理中, 不要催了, 越催越慢, 再催熄火
正在处理中, 不要催了, 越催越慢, 再催熄火
正在处理中, 不要催了, 越催越慢, 再催熄火
task over
 */
