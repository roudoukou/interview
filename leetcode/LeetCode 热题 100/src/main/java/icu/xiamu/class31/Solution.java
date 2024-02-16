package icu.xiamu.class31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 31. 下一个排列
 * https://leetcode.cn/problems/next-permutation/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    public void nextPermutation(int[] nums) {
        process1(nums, 0);
        System.out.println(result);
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void process1(int[] nums, int index) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) path.add(nums[i]);
            else continue;
            process1(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Solution().nextPermutation(new int[]{1, 2, 3});
        new Solution().nextPermutation(new int[]{3, 2, 1});
        new Solution().nextPermutation(new int[]{1, 1, 5});
    }
}