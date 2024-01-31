package icu.xiamu.class1657;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public boolean closeStrings(String word1, String word2) {
        return solve1(word1, word2);
    }

    private boolean solve1(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] countA = new int[26];
        int[] countB = new int[26];

        char[] chars1 = word1.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            countA[chars1[i] - 'a']++;
        }

        char[] chars2 = word2.toCharArray();
        for (int i = 0; i < chars2.length; i++) {
            countB[chars2[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) { // 说明当A中有值的时候, B数组也必须要存在值, 否则直接返回false
            if ((countA[i] == 0) != (countB[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(countA);
        Arrays.sort(countB);

        // for (int i = 0; i < 26; i++) {
        //     if (countA[i] != countB[i]) {
        //         return false;
        //     }
        // }

        return Arrays.equals(countA, countB);
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().closeStrings("abc", "bca"));
        // System.out.println(new Solution().closeStrings("a", "aa"));
        System.out.println(new Solution().closeStrings("cabbba", "abbccc"));
    }
}