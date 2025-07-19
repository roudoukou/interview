package icu.xiamu.code17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 41. 缺失的第一个正数
 * <a href="https://leetcode.cn/problems/first-missing-positive/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        nums = Arrays.stream(nums).distinct().sorted().toArray();
        int min = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            if (min != nums[i]) {
                return min;
            }
            min++;
        }

        return min;
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().firstMissingPositive(new int[]{1, 2, 0}));
        // System.out.println(new Solution().firstMissingPositive(new int[]{3, 4, -1, 1}));
        // System.out.println(new Solution().firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        // System.out.println(new Solution().firstMissingPositive(new int[]{1}));
        System.out.println(new Solution().firstMissingPositive(new int[]{0, 2, 2, 1, 1}));
    }
}