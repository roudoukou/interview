package icu.xiamu.class459;

/**
 * https://leetcode.cn/problems/repeated-substring-pattern/description/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return solve1(s);
    }

    private boolean solve1(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("abab"));
        System.out.println(new Solution().repeatedSubstringPattern("aba"));
        System.out.println(new Solution().repeatedSubstringPattern("abcabcabcabc"));
    }
}