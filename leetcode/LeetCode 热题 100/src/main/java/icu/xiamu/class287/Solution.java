package icu.xiamu.class287;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 287. 寻找重复数
 * https://leetcode.cn/problems/find-the-duplicate-number/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    public int findDuplicate(int[] nums) {
        return solve3(nums);
    }

    /**
     * stream
     * @param nums
     * @return
     */
    private int solve3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        return Arrays.stream(nums).filter(num -> !set.add(num)).findFirst().orElse(0);
    }

    /**
     * 借助set
     *
     * @param nums
     * @return
     */
    private int solve2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            if (set.contains(num)) return num;
            else set.add(num);
        }
        return 0;
    }

    /**
     * 暴力 超时
     *
     * @param nums
     * @return
     */
    private int solve1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new Solution().findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}