package icu.xiamu.class1004;

/**
 * https://leetcode.cn/problems/max-consecutive-ones-iii/submissions/499857569/?envType=study-plan-v2&envId=leetcode-75
 *
 * 这题跟上一题解法类似, 可以两题一块刷
 * https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        return solve1(nums, k);
    }

    private int solve1(int[] nums, int k) {

        int ans = Integer.MIN_VALUE;
        int zero = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zero++;

                while (zero > k) {
                    if (nums[left++] == 0) {
                        zero--;
                    }
                }
            }

            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(new Solution().longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}