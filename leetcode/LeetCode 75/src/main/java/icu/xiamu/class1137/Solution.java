package icu.xiamu.class1137;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int tribonacci(int n) {
        return solve2(n);
    }

    private int solve2(int n) {
        int[] dp = {0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513, 35890, 66012, 121415, 223317, 410744, 755476, 1389537, 2555757, 4700770, 8646064, 15902591, 29249425, 53798080, 98950096, 181997601, 334745777, 615693474, 1132436852, 2082876103};
        return dp[n];
    }

    int[] dp = new int[38];

    private int solve1(int n) {
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
        System.out.println(new Solution().tribonacci(37));
    }
}