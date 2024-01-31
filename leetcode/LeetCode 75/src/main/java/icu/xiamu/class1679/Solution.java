package icu.xiamu.class1679;

import java.util.Arrays;

class Solution {
    public int maxOperations(int[] nums, int k) {
        return solve1(nums, k);
    }

    private int solve1(int[] nums, int k) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        int answer = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                answer++;
                left++;
                right--;
            } else if (sum > k) {
                right--;
            } else {
                left++;
                // right--;
            }
            // <k left++ right--
            // >k 只移动right--
            // =k 计数器++ left++ right--
            // 1 3 3 3 4 5 7
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxOperations(new int[]{2, 2, 2, 3, 1, 1, 4, 1}, 4));
        System.out.println(new Solution().maxOperations(new int[]{1, 2, 3, 4}, 5));
        System.out.println(new Solution().maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }
}