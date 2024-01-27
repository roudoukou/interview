package icu.xiamu.class1572;

/**
 * https://leetcode.cn/problems/matrix-diagonal-sum/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public int diagonalSum(int[][] mat) {
        return solve1(mat);
    }

    private int solve1(int[][] mat) {
        // 奇数
        int result = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i == j) {
                    result += mat[i][j];
                }
                if (i + j == mat.length - 1) {
                    result += mat[i][j];
                }
            }
        }

        if ((mat.length & 1) != 0) {
            result -= mat[mat.length / 2][mat.length / 2];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().diagonalSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})); // 25
        System.out.println(new Solution().diagonalSum(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}})); // 8
        System.out.println(new Solution().diagonalSum(new int[][]{{5}}));  // 5
    }
}