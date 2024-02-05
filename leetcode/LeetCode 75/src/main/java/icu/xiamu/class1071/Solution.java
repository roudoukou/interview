package icu.xiamu.class1071;

/**
 * https://leetcode.cn/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        return solve1(str1, str2);
    }

    private String solve1(String str1, String str2) {
        int gcd = gcd(str1.length(), str2.length());

        String substring = str2.substring(0, gcd);
        StringBuilder stringBuilder1 = new StringBuilder();
        int length = str1.length() / gcd;
        for (int i = 0; i < length ; i++) {
            stringBuilder1.append(substring);
        }

        length = str2.length() / gcd;
        StringBuilder stringBuilder2 = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder2.append(substring);
        }
        return stringBuilder1.toString().equals(str1) && stringBuilder2.toString().equals(str2) ? substring : "";
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().gcdOfStrings("AAAAAAAAA", "AAACCC")); // 9 6 => 最大公约数3 最大公倍数18
        System.out.println(new Solution().gcdOfStrings("ABCDEF", "ABC"));
        System.out.println(new Solution().gcdOfStrings("ABCABC", "ABC"));
        System.out.println(new Solution().gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(new Solution().gcdOfStrings("LEET", "CODE"));
    }
}