package icu.xiamu.class867;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/transpose-matrix/description/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] ans = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().transpose(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        })));

        System.out.println(Arrays.deepToString(new Solution().transpose(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        })));
    }
}