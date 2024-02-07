package icu.xiamu.class1318;

/**
 * https://leetcode.cn/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int minFlips(int a, int b, int c) {
        return solve1(a, b, c);
    }

    private int solve1(int a, int b, int c) {

        String aBinary = String.format("%30s", Integer.toBinaryString(a)).replace(' ', '0');
        String bBinary = String.format("%30s", Integer.toBinaryString(b)).replace(' ', '0');
        String cBinary = String.format("%30s", Integer.toBinaryString(c)).replace(' ', '0');

        int ans = 0;
        for (int i = 0; i < cBinary.length(); i++) {
            if ((aBinary.charAt(i) | bBinary.charAt(i)) == cBinary.charAt(i)) {

            } else if (cBinary.charAt(i) == '0') {
                if (aBinary.charAt(i) == '1') ans++;
                if (bBinary.charAt(i) == '1') ans++;
                // 0 | 1 => 1
                // 1 | 0 => 1 这个刚上面一样
                // 1 | 1 => 1 最少步骤就不可以不考虑这个
                // 0 | 0 => 0
            } else if (cBinary.charAt(i) == '1') {
                if (aBinary.charAt(i) == '0' && bBinary.charAt(i) == '0') ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // String binaryString = Integer.toBinaryString(1_000_000_000);// 111011100110101100101000000000  30

        System.out.println(new Solution().minFlips(2, 6, 5));
        System.out.println(new Solution().minFlips(4, 2, 7));
        System.out.println(new Solution().minFlips(1, 2, 3));
    }
}