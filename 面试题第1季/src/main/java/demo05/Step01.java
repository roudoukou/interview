package demo05;

/**
 * 有n步台阶, 一次只能上1步或2步, 共有多少种走法?
 */
public class Step01 {

    // 实现f(n) : 求n步台阶, 一共有几种走法
    public static int f(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(n + "不能小于1");
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return f(n-2) + f(n-1);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(f(40));          // 165580141
        long end = System.currentTimeMillis();
        System.out.println(end - start);        // 461ms
    }

}
