package icu.xiamu.class746;

/**
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return solve2(cost);
    }

    private int solve2(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] += Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    private int solve1(int[] cost) {
        int[] dp = new int[1001];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] += Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(new Solution().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}