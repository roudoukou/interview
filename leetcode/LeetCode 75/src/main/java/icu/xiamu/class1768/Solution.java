package icu.xiamu.class1768;

/**
 * https://leetcode.cn/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=leetcode-75
 */
public class Solution {
    public String mergeAlternately(String word1, String word2) {

        return solve1(word1, word2);

    }

    private String solve1(String word1, String word2) {

        int length1 = word1.length();
        int length2 = word2.length();
        int minLength = Math.min(length1, length2);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            stringBuilder.append(word1.charAt(i));
            stringBuilder.append(word2.charAt(i));
        }

        if (length1 > length2) {
            String substring = word1.substring(length2);
            stringBuilder.append(substring);
        } else if (length1 < length2){
            String substring = word2.substring(length1);
            stringBuilder.append(substring);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mergeAlternately("abc", "pqr"));
        System.out.println(new Solution().mergeAlternately("ab", "pqrs"));
        System.out.println(new Solution().mergeAlternately("abcd", "pq"));
    }
}
