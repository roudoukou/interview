package icu.xiamu.code16;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * <a href="https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int xxx = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                xxx *= nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] != 0 ? (xxx / nums[i]) : xxx;
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}