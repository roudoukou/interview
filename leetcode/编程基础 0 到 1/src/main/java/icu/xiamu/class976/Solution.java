package icu.xiamu.class976;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/largest-perimeter-triangle/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public int largestPerimeter(int[] nums) {
        return solve1(nums);
    }

    private int solve1(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length - 1;
        for (int i = length; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(new Solution().largestPerimeter(new int[]{1, 2, 1, 10}));
        System.out.println(new Solution().largestPerimeter(new int[]{3, 6, 2, 3}));
    }
}