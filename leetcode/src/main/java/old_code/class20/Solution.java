package class20;

import java.util.Stack;
import java.util.stream.IntStream;

class Solution {
    Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        return process1(s);
        // 用stream反而耗时更长了
        // return process2(s);
    }

    private boolean process2(String s) {
        Stack<Character> stack = new Stack<>();
        // 使用 IntStream 来遍历字符的索引
        return IntStream.range(0, s.length()).allMatch(i -> {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                return true;
            } else if (!stack.isEmpty() && ((c == ')' && stack.peek().equals('(')) ||
                    (c == '}' && stack.peek().equals('{')) ||
                    (c == ']' && stack.peek().equals('[')))) {
                stack.pop();
                return true;
            } else {
                return false;
            }
        }) && stack.isEmpty();
    }

    private boolean process1(String s) {
        if (s.length() <= 1 || s.charAt(0) == ']' || s.charAt(0) == '}' || s.charAt(0) == ')' || s.length() % 2 == 1) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty() && stack.peek().equals('(') && c == ')') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek().equals('{') && c == '}') {
                stack.pop();
            } else if (!stack.isEmpty() &&  stack.peek().equals('[') && c == ']') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()")); // true
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("(]"));
        System.out.println(new Solution().isValid("([])"));
        System.out.println(new Solution().isValid("]"));
        System.out.println(new Solution().isValid("){"));
        System.out.println(new Solution().isValid(")(){}")); // false
        System.out.println(new Solution().isValid("(])")); // false
        System.out.println(new Solution().isValid("([}}])")); // false
    }
}