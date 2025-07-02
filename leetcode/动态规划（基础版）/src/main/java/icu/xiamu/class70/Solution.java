package icu.xiamu.class70;

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if (n <= 1) return dp[n];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(1));
        System.out.println(new Solution().climbStairs(2));
        System.out.println(new Solution().climbStairs(3));
        System.out.println(new Solution().climbStairs(5));
    }
}