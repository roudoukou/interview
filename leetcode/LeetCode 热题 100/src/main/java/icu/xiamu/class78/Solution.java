package icu.xiamu.class78;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集: https://leetcode.cn/problems/subsets/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        process(nums, 0);
        result.add(new ArrayList<>()); // 处理一个特殊值
        return result;
    }

    private void process(int[] nums, int index) {
        if (index == nums.length) {
            // result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            process(nums, i+1);
            result.add(new ArrayList<>(path));
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
        System.out.println(new Solution().subsets(new int[]{0}));
    }
}