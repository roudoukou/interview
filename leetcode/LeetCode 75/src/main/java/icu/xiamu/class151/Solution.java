package icu.xiamu.class151;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public String reverseWords(String s) {
        return solve1(s);
    }

    private String solve1(String s) {
        s = s.trim();

        String[] split = s.split(" ");
        Stack<String> stack = new Stack<>();
        for (String s1 : split) {
            if (s1.equals("")) {
                continue;
            }
            stack.push(s1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        String pop = stack.pop();
        stringBuilder.append(pop);
        while (!stack.isEmpty()) {
            pop = stack.pop();
            stringBuilder.append(' ');
            stringBuilder.append(pop);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("the sky is blue"));
        System.out.println(new Solution().reverseWords("  hello world  "));
        System.out.println(new Solution().reverseWords("a good   example"));
    }
}