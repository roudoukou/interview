package icu.xiamu.year2023.class70;

/**
 * https://leetcode.cn/problems/climbing-stairs/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    public int climbStairs(int n) {
        return solve1(n);
    }

    private int solve1(int n) {

        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(2));
        System.out.println(new Solution().climbStairs(3));
        System.out.println(new Solution().climbStairs(4));
    }
}