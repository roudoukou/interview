package icu.xiamu.code13;

import io.netty.util.NetUtil;

/**
 * 最大子数组和
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public int maxSubArray(int[] nums) {
        return process2(nums);
    }

    private int process2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int globalMax = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }

    /**
     * 加一个或者丢一个，这种算法没有充分考虑到加两个，三个可能会让结果变得更优
     * @param nums
     * @return
     */
    private static int process1(int[] nums) {
        // 加一个
        // 或者丢一个
        int left = 0, right = 0, sum = 0, add = 0, sub = 0;
        while (right < nums.length) {
            add = sum + nums[right];
            if (right != left) {
                sub = sum + nums[right] - nums[left];
            } else {
                sub = Integer.MIN_VALUE;
            }

            if (add > sub) {
                sum = add;
            } else {
                sum = sub;
                left++;
            }

            right++;
        }


        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Solution().maxSubArray(new int[]{1}));
        System.out.println(new Solution().maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}