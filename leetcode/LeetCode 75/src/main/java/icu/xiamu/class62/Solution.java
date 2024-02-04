package icu.xiamu.class62;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/unique-paths/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int uniquePaths(int m, int n) {
        return solve3(m, n);
    }

    // 0ms , 直接使用循环初始值
    private int solve3(int m, int n) {

        // 特殊情况 m=1 || n=1

        // 初始化
        int [][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    // 运行用时1ms , 缩写dp数组的大小
    private int solve2(int m, int n) {

        // 特殊情况 m=1 || n=1

        // 初始化
        int [][] dp = new int[m][n];
        Arrays.fill(dp[0], 1); // 设置0行为1
        Arrays.stream(dp).forEach(row -> row[0] = 1); // 设置0列为1

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    // 运行用时2ms
    // (3, 7)的路径 = (3, 6)的路径 + (2, 7)的路径
    // (3, 6)的路径 = (3, 5)的路径 + (2, 6)的路径
    // (3, 5)的路径 = (3, 4)的路径 + (2, 5)的路径
    // ...
    // (m, n)的路径 = (m, n-1)的路径 + (m-1, n)的路径
    private int solve1(int m, int n) {

        // 特殊情况 m=1 || n=1

        // 初始化
        int [][] dp = new int[101][101];
        Arrays.fill(dp[0], 1); // 设置0行为1
        Arrays.stream(dp).forEach(row -> row[0] = 1); // 设置0列为1

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
        System.out.println(new Solution().uniquePaths(3, 2));
        System.out.println(new Solution().uniquePaths(7, 3));
        System.out.println(new Solution().uniquePaths(3, 3));
    }
}