package icu.xiamu;

public class BM62 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @return int整型
     */
    public int Fibonacci (int n) {
        // write code here
        return solve1(n);
    }

    private int solve1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return solve1(n-1) + solve1(n-2);
    }

    public static void main(String[] args) {
        System.out.println(new BM62().Fibonacci(40));
    }
}

