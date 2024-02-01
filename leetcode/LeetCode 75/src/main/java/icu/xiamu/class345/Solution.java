package icu.xiamu.class345;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/reverse-vowels-of-a-string/submissions/499886042/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public String reverseVowels(String s) {
        return solve1(s);
    }

    private String solve1(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if ("aeiouAEIOU".contains(String.valueOf(chars[left])) && "aeiouAEIOU".contains(String.valueOf(chars[right]))) {
                char c = chars[left];
                chars[left] = chars[right];
                chars[right] = c;

                left++;
                right--;
            } else if ("aeiouAEIOU".contains(String.valueOf(chars[left]))) {
                right--;
            } else if ("aeiouAEIOU".contains(String.valueOf(chars[right]))) {
                left++;
            } else {
                left++;
                right--;
            }
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
        System.out.println(new Solution().reverseVowels("leetcode"));
    }
}