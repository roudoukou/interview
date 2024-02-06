package icu.xiamu.backtrace.class46;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/permutations/description/
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        process(nums, 0);
        return result;
    }

    private void process(int[] nums, int index) {

        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 第一次的for循坏表示是第一位可能出现的值： 1 2 3
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
            } else {
                continue;
            }
            process(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
        System.out.println(new Solution().permute(new int[]{0, 1}));
        System.out.println(new Solution().permute(new int[]{1}));
    }
}