package icu.xiamu.class242;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/valid-anagram/description/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        return solve1(s, t);
    }

    private boolean solve1(String s, String t) {
        int[] nums = new int[30];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            nums[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
        System.out.println(new Solution().isAnagram("rat", "car"));
    }
}