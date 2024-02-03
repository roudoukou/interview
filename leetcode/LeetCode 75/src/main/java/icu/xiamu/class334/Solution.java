package icu.xiamu.class334;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {
        return solve3(nums);
    }

    /**
     * 大力出奇迹, 又尼玛的超时了?
     *
     * @param nums
     * @return
     */
    private boolean solve3(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if (set.size() < 3) {
            return false;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] >= nums[j]) {

                } else {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] < nums[j] && nums[j] < nums[k]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * 好绕, 我已经分不出这里头写了啥了
     *
     * @param nums
     * @return
     */
    private boolean solve2(int[] nums) {
        int right1 = 0;
        int left1 = 0;
        while (left1 < nums.length - 2) {
            int result1 = solve1(nums, left1, right1 + 1);
            if (result1 != -1) {
                int right2 = result1;
                int left2 = result1;
                while (right2 < nums.length - 1) {
                    int result2 = solve1(nums, left2, right2 + 1);
                    if (result2 != -1) {
                        return true;
                    }
                    right2++;
                }

                if (right2 == nums.length - 1) {
                    left1++;
                }
            }
            left1++;
            right1++;
        }

        return false;
    }

    private int solve1(int[] nums, int left, int right) {
        while (right < nums.length) {
            if (nums[left] < nums[right]) {
                return right;
            } else {
                right++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().increasingTriplet(new int[]{1, 5, 0, 4, 1, 3})); // true
        System.out.println(new Solution().increasingTriplet(new int[]{6, 7, 1, 2})); // false
        System.out.println(new Solution().increasingTriplet(new int[]{1, 2, 2147483647})); // true
        System.out.println(new Solution().increasingTriplet(new int[]{4, 5, 2147483647, 1, 2})); // true
        System.out.println(new Solution().increasingTriplet(new int[]{20, 100, 10, 12, 5, 13})); // ture
        System.out.println(new Solution().increasingTriplet(new int[]{1, 2, 3, 4, 5})); // true
        System.out.println(new Solution().increasingTriplet(new int[]{5, 4, 3, 2, 1})); // false
        System.out.println(new Solution().increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));// true
    }
}