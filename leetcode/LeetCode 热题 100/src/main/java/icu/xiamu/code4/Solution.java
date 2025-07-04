package icu.xiamu.code4;

import java.util.Arrays;

/**
 * 283. 移动零
 * <a href="https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public void moveZeroes(int[] nums) {
        // process1(nums);
        process2(nums);
    }

    private void process2(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int swap = nums[right];
                nums[right] = nums[left];
                nums[left] = swap;
                left++;
            }
            right++;
        }
    }

    private void process1(int[] nums) {
        int[] result = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[j++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (result[i] != 0) {
                nums[i] = result[i];
            } else {
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{0};
        new Solution().moveZeroes(input);
        System.out.println(Arrays.toString(input));

        input = new int[]{1, 3, 12};
        new Solution().moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }
}