package icu.xiamu.code3;

import java.util.Arrays;
import java.util.Map;

/**
 * 128. 最长连续序列
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        // Arrays.sort(nums);
        nums = Arrays.stream(nums).distinct().sorted().toArray();

        int count = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i] - 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return nums.length > 0 ? max + 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(new Solution().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(new Solution().longestConsecutive(new int[]{1, 0, 1, 2}));
        System.out.println(new Solution().longestConsecutive(new int[]{1}));
        System.out.println(new Solution().longestConsecutive(new int[]{}));
        System.out.println(new Solution().longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
    }
}