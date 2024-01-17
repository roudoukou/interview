public class Demo1 {
    public static void main(String[] args) {
        new Demo1().threadPrint(2, 1, 10);
    }

    public void threadPrint(int threadCount, int start, int end) {

        MyPrinter myPrinter = new MyPrinter();
        new Thread(() -> {
            for (int i = start; i <= end; i++) {
                if (i % 2 != 0) {
                    myPrinter.print1(i);
                }
            }
        }, "Thread-1").start();

        new Thread(() -> {
            for (int i = start; i <= end; i++) {
                if (i % 2 == 0) {
                    myPrinter.print2(i);
                }
            }
        }, "Thread-2").start();
    }

}

class MyPrinter {
    boolean flag = true;

    public synchronized void print1(Integer value) {
        while (!flag) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + value);
        flag = false;
        this.notify();

    }

    public synchronized void print2(Integer value) {
        while (flag) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + value);
        flag = true;
        this.notify();
    }
}