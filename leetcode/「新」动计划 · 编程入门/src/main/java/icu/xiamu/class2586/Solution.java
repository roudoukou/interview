package icu.xiamu.class2586;

/**
 * https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int index = left; index <= right; index++) {
            if ("aeiou".contains(String.valueOf(words[index].charAt(0)))
            && "aeiou".contains(String.valueOf(words[index].charAt(words[index].length()-1)))
            ) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().vowelStrings(new String[]{"are", "amy", "u"}, 0, 2));
        System.out.println(new Solution().vowelStrings(new String[]{"hey", "aeo", "mu", "ooo", "artro"}, 1, 4));
    }
}