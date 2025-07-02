package icu.xiamu.class1137;

class Solution {
    public int tribonacci(int n) {
        if (n <= 0 || n > 37) return 0;

        int[] dp = new int[38];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().tribonacci(4));
        System.out.println(new Solution().tribonacci(25));
    }
}