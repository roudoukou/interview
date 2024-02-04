package icu.xiamu.class394;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/decode-string/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public String decodeString(String s) {
        return solve2(s);
    }

    /**
     * 对solve1的判断数字进行略微优化
     * @param s
     * @return
     */
    private String solve2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
            if (c == ']') {

                // stack pop ']'
                stack.pop();

                StringBuilder innerBuilder = new StringBuilder();

                while (stack.peek() != '[') {
                    Character pop = stack.pop();
                    innerBuilder.append(pop);
                }

                innerBuilder.reverse();
                // stack pop '['
                stack.pop();

                // 获得倍数
                Integer value = 0;
                StringBuilder numBuilder = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())){
                    Character pop = stack.pop();
                    numBuilder.append(pop);
                }

                value = Integer.valueOf(numBuilder.reverse().toString());

                StringBuilder outerBuilder = new StringBuilder();
                while (value-- != 0) {
                    outerBuilder.append(innerBuilder);
                }

                // outerBuilder to stack
                for (char c1 : outerBuilder.toString().toCharArray()) {
                    stack.push(c1);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }

    private String solve1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
            if (c == ']') {

                // stack pop ']'
                stack.pop();

                StringBuilder innerBuilder = new StringBuilder();
                
                while (stack.peek() != '[') {
                    Character pop = stack.pop();
                    innerBuilder.append(pop);
                }
                
                innerBuilder.reverse();
                // stack pop '['
                stack.pop();

                // 获得倍数
                // Character pop = stack.pop(); // 仅仅只是个位数, 两位数呢? 三位数呢?
                // Integer value = Integer.valueOf(pop.toString());

                // 获得倍数
                Integer value = 0;
                StringBuilder numBuilder = new StringBuilder();
                while (!stack.isEmpty() && "1234567890".contains(stack.peek().toString())) {
                    Character pop = stack.pop();
                    numBuilder.append(pop);
                }

                value = Integer.valueOf(numBuilder.reverse().toString());

                StringBuilder outerBuilder = new StringBuilder();
                while (value-- != 0) {
                    outerBuilder.append(innerBuilder);
                }

                // outerBuilder to stack
                for (char c1 : outerBuilder.toString().toCharArray()) {
                    stack.push(c1);
                }

            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("100[leetcode]")); // 100leetcodeleetcodeleetcode....
        System.out.println(new Solution().decodeString("3[a]2[bc]")); // aaabcbc
        System.out.println(new Solution().decodeString("3[a2[c]]")); // accaccacc
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
        System.out.println(new Solution().decodeString("abc3[cd]xyz")); // abccdcdcdxyz
    }
}