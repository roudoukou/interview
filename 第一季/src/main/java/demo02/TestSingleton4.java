package demo02;

import java.util.concurrent.*;

public class TestSingleton4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*Singleton4 s1 = Singleton4.getInstance();
        Singleton4 s2 = Singleton4.getInstance();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);*/

        // (这样创建出来的实例对象存在线程不安全的问题, 当创建对象的过程中Thread.sleep(1000), 需要使用)
        Callable<Singleton4> c = new Callable<Singleton4>() {
            @Override
            public Singleton4 call() throws Exception {
                return Singleton4.getInstance();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Singleton4> f1 = executorService.submit(c);
        Future<Singleton4> f2 = executorService.submit(c);

        Singleton4 s1 = f1.get();
        Singleton4 s2 = f2.get();

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        executorService.shutdown();
    }
}
