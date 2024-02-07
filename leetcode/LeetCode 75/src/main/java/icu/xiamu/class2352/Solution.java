package icu.xiamu.class2352;

/**
 * https://leetcode.cn/problems/equal-row-and-column-pairs/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int equalPairs(int[][] grid) {
        return solve1(grid);
    }

    private int solve1(int[][] grid) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().equalPairs(new int[][]{
                {3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}
        }));

        System.out.println(new Solution().equalPairs(new int[][]{
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        }));
    }
}