package icu.xiamu.class1512;

/**
 * https://leetcode.cn/problems/number-of-good-pairs/submissions/500156816/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
    }
}