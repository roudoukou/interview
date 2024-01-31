package icu.xiamu.class392;

/**
 * https://leetcode.cn/problems/is-subsequence/submissions/499662863/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        return solve1(s, t);
    }

    private boolean solve1(String s, String t) {

        if (s == null || s == "" || s.length() == 0) {
            return true;
        }

        int p1 = 0;
        int p2 = 0;

        while (p2 != t.length()) {
            if (p1 < s.length() && s.charAt(p1) == t.charAt(p2)) {
                p1++;
            }
            p2++;
        }

        return p1 == s.length();
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
        // System.out.println(new Solution().isSubsequence("axc", "ahbgdc"));
        // System.out.println(new Solution().isSubsequence("", "ahbgdc"));
        System.out.println(new Solution().isSubsequence("b", "abc"));
    }
}