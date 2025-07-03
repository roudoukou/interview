package icu.xiamu.year2023.class46;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        process2(nums, 0);
        return result;
    }

    private void process2(int[] nums, int index) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
            } else continue;
            process2(nums, i+1);
            path.remove(path.size()-1);
        }
    }

/*
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    private void process1(int[] nums, int index) {

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
            process1(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
*/

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
        System.out.println(new Solution().permute(new int[]{0, 1}));
        System.out.println(new Solution().permute(new int[]{1}));
    }

}