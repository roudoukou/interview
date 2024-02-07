package icu.xiamu.class118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/pascals-triangle/submissions/501176782/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        return solve1(numRows);
    }

    private List<List<Integer>> solve1(int numRows) {

        /**
         * 1
         * 1 1
         * 1 2 1
         * 1 3 3 1
         * 1 4 6 4 1
         */
        int[][] dp = new int[31][31];
        for (int i = 1; i <= numRows; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            rows.add(dp[i][0]);
            for (int j = 1; j <= numRows; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                if (dp[i][j] != 0) rows.add(dp[i][j]);
            }
            result.add(rows);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(5));
        System.out.println(new Solution().generate(1));
    }
}