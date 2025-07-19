package icu.xiamu.code15;

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {

        if (nums.length == 1) return;

        int[] ints = Arrays.copyOf(nums, nums.length);

        int j = 0;
        int i1 = (nums.length - (k % nums.length));
        for (int i = i1; i < ints.length; i++) {
            nums[j++] = ints[i];
        }
        for (int i = 0; i < i1; i++) {
            nums[j++] = ints[i];
        }

        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(nums[i] + " ");
        // }
        // System.out.println();
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        new Solution().rotate(new int[]{-1, -100, 3, 99}, 2);
        new Solution().rotate(new int[]{-1}, 2);
        new Solution().rotate(new int[]{1, 2}, 7);
    }
}