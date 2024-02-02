package icu.xiamu.class2413;

/**
 * https://leetcode.cn/problems/smallest-even-multiple/submissions/500154971/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public int smallestEvenMultiple(int n) {
        return 2 * n / gcd(2, n);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestEvenMultiple(5));
        System.out.println(new Solution().smallestEvenMultiple(6));
    }
}