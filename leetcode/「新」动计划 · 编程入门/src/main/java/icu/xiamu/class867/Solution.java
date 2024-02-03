package icu.xiamu.class867;

/**
 * https://leetcode.cn/problems/transpose-matrix/description/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public int[][] transpose(int[][] matrix) {
        // 未完成
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }
}