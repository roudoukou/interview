package icu.xiamu;

import java.util.Arrays;

public class BM64 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param cost int整型一维数组
     * @return int整型
     */
    public int minCostClimbingStairs(int[] cost) {
        // write code here
        int[] dp = new int[100004];
        Arrays.fill(dp, 0);
        return solve3(cost, dp);
    }

    // 暴力递归
    private int solve1(int[] cost, int index) {
        if (index >= cost.length) {
            return 0;
        }

        // 特殊处理初始值
        if (index == 0) {
            // 选择0的 走1步 代价
            int p1 = cost[index] + solve1(cost, index + 1);
            // 选择0的 走2步 代价
            int p2 = cost[index] + solve1(cost, index + 2);

            int p3, p4;
            if (index + 1 >= cost.length) {
                p3 = 0;
                p4 = 0;
            } else {
                // 选择1 走1步 代价
                p3 = cost[index + 1] + solve1(cost, index + 1 + 1);
                // 选择1 走2步 代价
                p4 = cost[index + 1] + solve1(cost, index + 1 + 2);
            }
            return Math.min(Math.min(p1, p2), Math.min(p3, p4));
        }

        int p1, p2;

        // 走一步的费用
        p1 = cost[index] + solve1(cost, index + 1);
        // 走两步的费用
        p2 = cost[index] + solve1(cost, index + 2);

        return Math.min(p1, p2);
    }

    // 动态规划, 参考的gpt
    private int solve2(int[] cost, int[] dp) {

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int index = 2; index < cost.length; index++) {
            dp[index] = Math.min(cost[index] + dp[index - 1], cost[index] + dp[index - 2]);
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    // 动态规划, 改造solve2
    private int solve3(int[] cost, int[] dp) {

        int N = cost.length;
        dp[N - 1] = cost[N - 1];
        dp[N - 2] = cost[N - 2];

        for (int index = N-3; index >= 0; index--) {
            int p1, p2;

            // 走一步的费用
            p1 = cost[index] + dp[index + 1];
            // 走两步的费用
            p2 = cost[index] + dp[index + 2];

            dp[index] = Math.min(p1, p2);
        }

        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        // int[] cost = {2, 5, 20};
        int[] cost = {2, 5};
        int result = new BM64().minCostClimbingStairs(cost);
        System.out.println("result = " + result);
    }
}
