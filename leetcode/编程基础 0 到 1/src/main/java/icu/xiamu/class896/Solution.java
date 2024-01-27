package icu.xiamu.class896;

/**
 * https://leetcode.cn/problems/monotonic-array/description/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public boolean isMonotonic(int[] nums) {
        return solve(nums);
    }

    private boolean solve(int[] nums) {
        int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {

            } else {
                flag++;
                break;
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {

            } else {
                flag++;
                break;
            }
        }
        return flag == 1 || flag == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(new Solution().isMonotonic(new int[]{1, 3, 2, 3}));
        System.out.println(new Solution().isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(new Solution().isMonotonic(new int[]{1, 1, 1, 1}));
    }


}