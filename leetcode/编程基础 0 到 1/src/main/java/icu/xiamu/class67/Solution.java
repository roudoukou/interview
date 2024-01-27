package icu.xiamu.class67;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * https://leetcode.cn/problems/add-binary/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public String addBinary(String a, String b) {
        return solve2(a, b);

        // return solve1(a, b);
    }

    private static String solve2(String a, String b) {
        BigInteger aaa = new BigInteger(a, 2);
        BigInteger bbb = new BigInteger(b, 2);

        return aaa.add(bbb).toString(2);
    }

    private static String solve1(String a, String b) {
        int aa = Integer.parseInt(a, 2);
        int bb = Integer.parseInt(b, 2);
        return Integer.toBinaryString(aa + bb);
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().addBinary("11", "1"));
        System.out.println(new Solution().addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}