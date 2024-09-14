package class8;

import javax.script.ScriptException;

class Solution {
    public int myAtoi(String s) {
        // 空格
        s = s.trim();

        // 符号 1 => + ; 0 => -
        int flag = 1;
        if (s.charAt(0) == '-') {
            flag = 0;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        // 跳过前导零
        for (char c : s.toCharArray()) {
            if (c == '0') {
                s = s.substring(1);
            }
            if (Character.isDigit(c)) {
                stringBuilder.append(c);
            }
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    public static void main(String[] args) throws ScriptException {
        // System.out.println(new Solution().myAtoi("42"));
        // System.out.println(new Solution().myAtoi("-042"));
        // System.out.println(new Solution().myAtoi("1337c0d3"));
        // System.out.println(new Solution().myAtoi("0-1"));
        // System.out.println(new Solution().myAtoi("words and 987"));
    }
}