package icu.xiamu.code1;

import java.util.Arrays;

/**
 * 两数之和
 * <a href="https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3, 3}, 6)));
    }
}