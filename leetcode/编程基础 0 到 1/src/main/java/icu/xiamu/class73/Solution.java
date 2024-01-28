package icu.xiamu.class73;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        solve1(matrix);
    }

    private void solve1(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    // 保存下来i, j
                    setMatrix(matrix, i, j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == Integer.MIN_VALUE+4 || matrix[i][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void setMatrix(int[][] matrix, int x, int y) {
        for (int i = 0; i < matrix[x].length; i++) {
            if (matrix[x][i] != 0) {
                matrix[x][i] = Integer.MIN_VALUE + 4;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][y] != 0) {
                matrix[i][y] = Integer.MIN_VALUE + 4; // 随便设置的特殊值，为了跳过特殊值
            }
        }
    }

    public static void main(String[] args) {
        int[][] input1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        new Solution().setZeroes(input1);
        System.out.println(Arrays.deepToString(input1));
        int[][] input2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new Solution().setZeroes(input2);
        System.out.println(Arrays.deepToString(input2));
    }
}