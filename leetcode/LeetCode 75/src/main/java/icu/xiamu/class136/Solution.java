package icu.xiamu.class136;

/**
 * https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int singleNumber(int[] nums) {
        return solve1(nums);
    }

    private int solve1(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            answer ^= num;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{2, 2, 1}));
        System.out.println(new Solution().singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(new Solution().singleNumber(new int[]{1}));

    }
}