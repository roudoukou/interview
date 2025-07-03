package icu.xiamu.year2023.class48;

/**
 * 48. 旋转图像
 * https://leetcode.cn/problems/rotate-image/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    /**
     * 反转两次即可
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        process1(matrix);
    }

    private void process1(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // source = matrix[i][j];
                // target = matrix[matrix.length-i-1][j];
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - i - 1][j];
                matrix[matrix.length - i - 1][j] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i <= j) {
                    // System.out.print(matrix[i][j] + " ");
                    // source = matrix[i][j];
                    // target = matrix[j][i];
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        // System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        new Solution().rotate(new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        });
    }
}