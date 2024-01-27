package icu.xiamu.class13;

/**
 * https://leetcode.cn/problems/roman-to-integer/description/?envType=study-plan-v2&envId=programming-skills
 */
enum Roman {

    I(1, "I"),
    V(5, "V"),
    X(10, "X"),
    L(50, "L"),
    C(100, "C"),
    D(500, "D"),
    M(1000, "M");

    private Integer num;
    private String message;

    Roman(Integer num, String message) {
        this.num = num;
        this.message = message;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

class Solution {
    public int romanToInt(String s) {
        return solve1(s);
    }

    private int solve1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            Roman roman = Roman.valueOf(String.valueOf(s.charAt(i)));
            Integer num = roman.getNum();
            result += num;
            if (i < s.length() - 1 && s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') { // IV 4
                result -= 2;
            }
            if (i < s.length() - 1 && s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') { // 9
                result -= 2;
            }
            if (i < s.length() - 1 && s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') { // 40
                result -= 20;
            }
            if (i < s.length() - 1 && s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') { // 90
                result -= 20;
            }
            if (i < s.length() - 1 && s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') { // 400
                result -= 200;
            }
            if (i < s.length() - 1 && s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') { // 900
                result -= 200;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("III"));
        System.out.println(new Solution().romanToInt("MCMXCIV"));
        System.out.println(new Solution().romanToInt("LVIII"));
        // 1000 100 1000 10 100 1 5
        // 2000 200 16
    }
}