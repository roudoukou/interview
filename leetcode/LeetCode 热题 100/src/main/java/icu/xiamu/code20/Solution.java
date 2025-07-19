package icu.xiamu.code20;

import java.util.Arrays;

/**
 * 48. 旋转图像
 * <a href="https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public void rotate(int[][] matrix) {

        int[][] result = Arrays.stream(matrix)
                .map(row -> Arrays.copyOf(row, row.length))
                .toArray(int[][]::new);

        for (int i = 0; i < result.length; i++) {
            int k = 0;
            for (int j = result[i].length-1; j >= 0; j--) {
                // int swap = matrix[j][i];
                // matrix[j][i] = matrix[i][j];
                // matrix[i][j] = swap;
                // System.out.print(result[j][i] + " ");
                matrix[i][k++] = result[j][i];
            }
        }

        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        new Solution().rotate(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
    }
}