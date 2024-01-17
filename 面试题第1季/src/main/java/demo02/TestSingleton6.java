package demo02;

import java.util.concurrent.*;

public class TestSingleton6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Singleton6> c = new Callable<Singleton6>() {
            @Override
            public Singleton6 call() throws Exception {
                return Singleton6.getInstance();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Singleton6> f1 = executorService.submit(c);
        Future<Singleton6> f2 = executorService.submit(c);

        Singleton6 s1 = f1.get();
        Singleton6 s2 = f2.get();

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        executorService.shutdown();
    }
}
