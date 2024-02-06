package icu.xiamu.backtrace.class46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        process(nums, 0);
        return result;
    }

    private void process(int[] nums, int index) {

        if (index == nums.length) {
            result.add(path);
            return;
        }

        // 第一次的for循坏表示是第一位可能出现的值： 1 2 3
        for (int i = index; i < nums.length; i++) {
            path.add(nums[index]);
            // index+1 = 2 表示第二次for循环，第二位可能出现的值：2 | 3
            // index+1 = 3 表示第三次for循环，第三位的值一定是3
            // 回退一个 path = [1, 2]
            // 此时index+1=2 第二位只能是3
            // 之后的循环, 貌似就卡死了???
            process(nums, index+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
        System.out.println(new Solution().permute(new int[]{0, 1}));
        System.out.println(new Solution().permute(new int[]{1}));
    }
}