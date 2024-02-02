package icu.xiamu.class198;

/**
 * https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=leetcode-75
 * 相当于爬楼梯算法, 每次爬楼爬两步或者三步
 */
class Solution {
    public int rob(int[] nums) {
        return solve1(nums);
    }

    int[] dp = new int[500];

    private int solve1(int[] nums) {

        if (nums.length <= 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = dp[0] + nums[2];

        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }

        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution().rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new Solution().rob(new int[]{0}));
    }
}