package icu.xiamu.class2390;

import java.util.Stack;

class Solution {
    public String removeStars(String s) {
        return solve2(s);
    }

    private String solve2(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c != '*') {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }

    /**
     * 超时算法, 使用正则表达式匹配
     * @param s 字符串
     * @return 字符串
     */
    private String solve1(String s) {
        while (s.contains("*")) {
            s = s.replaceAll("[a-z]\\*", "");
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeStars("leet**cod*e"));
        System.out.println(new Solution().removeStars("erase*****"));
    }
}