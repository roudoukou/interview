package icu.xiamu.code18;

import java.util.*;

/**
 * 73. 矩阵置零
 * <a href="https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (row.contains(i)) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (column.contains(j)) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 输出专用
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        new Solution().setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        new Solution().setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }
}