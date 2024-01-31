package icu.xiamu.class215;

import java.util.*;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return solve2(nums, k);
    }

    private int solve2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private int solve1(int[] nums, int k) {
        Integer[] array = Arrays.stream(nums).boxed().sorted().toArray(Integer[]::new);
        return array[array.length - k];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new Solution().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}