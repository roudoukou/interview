package icu.xiamu.class1732;

/**
 * https://leetcode.cn/problems/find-the-highest-altitude/submissions/499869237/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int largestAltitude(int[] gain) {
        return solve1(gain);
    }

    private int solve1(int[] gain) {

        // 高 - 矮 = 差
        int[] result = new int[gain.length + 1];
        int ans = 0;
        for (int i = 0; i < gain.length; i++) {
            result[i + 1] = result[i] + gain[i];
            ans = Math.max(ans, result[i + 1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(new Solution().largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }
}