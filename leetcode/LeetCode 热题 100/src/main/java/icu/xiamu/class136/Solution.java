package icu.xiamu.class136;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 136. 只出现一次的数字
 * https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    public int singleNumber(int[] nums) {
        return solve3(nums);
    }

    private int solve3(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }

    private int solve2(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{2, 2, 1}));
        System.out.println(new Solution().singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(new Solution().singleNumber(new int[]{1}));
    }
}