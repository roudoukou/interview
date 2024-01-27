package icu.xiamu.class1672;

/**
 * https://leetcode.cn/problems/richest-customer-wealth/submissions/498798613/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
        return solve1(accounts);
    }

    private int solve1(int[][] accounts) {
        int accountMax = 0;
        for (int i = 0; i < accounts.length; i++) {
            int account = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                account += accounts[i][j];
            }
            accountMax = Math.max(accountMax, account);
        }
        return accountMax;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}})); // 6
        System.out.println(new Solution().maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}})); // 10
        System.out.println(new Solution().maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}})); // 17
    }
}