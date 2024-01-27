package icu.xiamu.class1232;

/**
 * https://leetcode.cn/problems/check-if-it-is-a-straight-line/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        return solve1(coordinates);
    }

    private boolean solve1(int[][] coordinates) {

        // 垂直斜率
        boolean flag = true;
        int vertical = coordinates[0][0];
        for (int i = 0; i < coordinates.length; i++) {
            if (coordinates[i][0] != vertical) {
                flag = false;
            }
        }
        if (flag) {
            return true;
        }

        double k = (double) (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        for (int i = 1; i < coordinates.length; i++) {
            for (int j = 1; j < coordinates[i].length; j++) {
                if (k != (double) (coordinates[i][j] - coordinates[i-1][j]) / (coordinates[i][j-1] - coordinates[i-1][j-1])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}})); // true
        System.out.println(new Solution().checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}})); //false
        System.out.println(new Solution().checkStraightLine(new int[][]{{0, 0}, {0, 1}, {0, -1}})); // true

    }
}