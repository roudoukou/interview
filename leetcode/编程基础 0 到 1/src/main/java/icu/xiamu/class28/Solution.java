package icu.xiamu.class28;

/**
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("sadbutsad", "sad"));
        System.out.println(new Solution().strStr("leetcode", "leeto"));
    }
}