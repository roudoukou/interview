package icu.xiamu.class50;

/**
 * https://leetcode.cn/problems/powx-n/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public double myPow(double x, int n) {
        return solve1(x, n);
    }

    private double solve1(double x, int n) {
        return Math.pow(x, n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.0, 10));
        System.out.println(new Solution().myPow(2.1, 3));
        System.out.println(new Solution().myPow(2.0, -2));
    }
}