package icu.xiamu.class724;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 没写出来....
 */
class Solution {
    public int pivotIndex(int[] nums) {
        return solve1(nums);
    }

    private int solve1(int[] nums) {
        int[] sumLeft = new int[nums.length];
        int[] sumRight = new int[nums.length];

        for (int num = 0; num < nums.length; num++) {
            // num left
            for (int i = num; i >= 0; i--) {
                sumLeft[i + 1] = sumLeft[i] + nums[i];
            }

            // num right
            for (int i = num; i < nums.length; i++) {
                sumRight[i + 1] = sumRight[i] + nums[i];
            }

            if (sumLeft[0] == sumRight[nums.length - 1]) {
                return num;
            }

            Arrays.fill(sumLeft, 0);
            Arrays.fill(sumRight, 0);
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(new Solution().pivotIndex(new int[]{1, 2, 3})); // -1
        System.out.println(new Solution().pivotIndex(new int[]{2, 1, -1})); // 0
    }
}
