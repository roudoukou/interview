package icu.xiamu.year2023.class31;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * https://leetcode.cn/problems/next-permutation/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    public void nextPermutation(int[] nums) {
        process1(nums);
    }

    /**
     * 找到最大值, 然后向前移动一位, 我貌似理解题意错了???
     * @param nums
     */
    private void process1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }

        if (nums[0] == max) {
            // 直接返回升序
            Arrays.sort(nums);
        } else {
            // 最大值向前移动一位
            int temp = nums[index-1];
            nums[index-1] = nums[index];
            nums[index] = temp;
        }


        System.out.println(Arrays.toString(nums));
    }


    public static void main(String[] args) {
        new Solution().nextPermutation(new int[]{1, 2, 3});
        new Solution().nextPermutation(new int[]{3, 2, 1});
        new Solution().nextPermutation(new int[]{1, 1, 5});
    }
}