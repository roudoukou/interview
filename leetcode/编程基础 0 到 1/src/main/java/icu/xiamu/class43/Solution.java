package icu.xiamu.class43;

import java.math.BigInteger;

/**
 * https://leetcode.cn/problems/multiply-strings/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public String multiply(String num1, String num2) {
        return solve1(num1, num2);
    }

    private String solve1(String num1, String num2) {
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);
        return n1.multiply(n2).toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("2", "3"));

    }
}