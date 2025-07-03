package icu.xiamu.year2023.class128;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int longestConsecutive(int[] nums) {
        return solve1(nums);
    }

    private int solve1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 0 1 1 2 先去重再排序
        nums = Arrays.stream(nums).boxed().collect(Collectors.toSet()).stream().sorted().mapToInt(Integer::intValue).toArray();

        int ans = Integer.MIN_VALUE;
        int seq = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                seq++;
            } else {
                ans = Math.max(ans, seq);
                seq = 1;
            }
        }
        ans = Math.max(ans, seq);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{1, 2, 0, 1}));
        System.out.println(new Solution().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}