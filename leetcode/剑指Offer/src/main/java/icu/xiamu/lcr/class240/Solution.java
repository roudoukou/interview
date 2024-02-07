package icu.xiamu.lcr.class240;

/**
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
 */
class Solution {
    /**
     * 2024-2-7 22:07:00 盲猜一波暴力会超时
     * 2024-2-7 22:10:15 ??? 草, 居然过了, 按理来说应该每一行去二分寻值
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        return solve1(matrix, target);
    }

    private boolean solve1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        }, 5));

        System.out.println(new Solution().searchMatrix(new int[][]{
                {1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}
        }, 20));
    }
}

/*

 */