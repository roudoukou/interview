package icu.xiamu.class1470;

/**
 * https://leetcode.cn/problems/shuffle-the-array/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public int[] shuffle(int[] nums, int n) {
        return solve1(nums, n);
    }

    private int[] solve1(int[] nums, int n) {

        int left = 0;
        int right = n;
        int index = 0;
        int[] ans = new int[nums.length];
        while (right < nums.length) {
            ans[index++] = nums[left++];
            ans[index++] = nums[right++];
        }
        return ans;
    }
}