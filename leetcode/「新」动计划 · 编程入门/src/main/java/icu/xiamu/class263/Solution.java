package icu.xiamu.class263;

/**
 * https://leetcode.cn/problems/ugly-number/submissions/500627596/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public boolean isUgly(int n) {
        return solve1(n);
    }

    private boolean solve1(int n) {
        if (n <= 0) {
            return false;
        }
        if (n <= 6) {
            return true;
        }

        int oldN = n;
        while (n > 5) {
            if (n % 2 == 0) n/=2;
            else if (n % 3 == 0) n/=3;
            else if (n % 5 == 0) n/=5;
            else break;
        }

        return n <= 5;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(10));
        System.out.println(new Solution().isUgly(6));
        System.out.println(new Solution().isUgly(1));
        System.out.println(new Solution().isUgly(14));
        System.out.println(new Solution().isUgly(8));
    }
}