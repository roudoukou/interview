package icu.xiamu.class283;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void moveZeroes(int[] nums) {
        solve1(nums);
    }

    private static void solve1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }

        int [] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != 0) {
                result[index++] = nums[i];
            }
        }

        System.arraycopy(result, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        new Solution().moveZeroes(new int[]{0, 1, 0, 3, 12});
        new Solution().moveZeroes(new int[]{0});
    }
}