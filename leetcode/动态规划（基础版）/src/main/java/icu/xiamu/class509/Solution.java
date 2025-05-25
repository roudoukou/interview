package icu.xiamu.class509;

class Solution {
    public int fib(int n) {
        if (n <= 0 || n > 30) return 0;

        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(1));
        System.out.println(new Solution().fib(2));
        System.out.println(new Solution().fib(3));
        System.out.println(new Solution().fib(4));
    }
}