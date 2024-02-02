package icu.xiamu.class326;

/**
 * https://leetcode.cn/problems/power-of-three/description/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        return solve1(n);
    }

    private boolean solve2(int n) {
        int[] ans = {3,9,27,81,243,729,2187,6561,19683,59049,177147,531441,1594323,4782969,14348907,43046721,129140163,387420489,1162261467};
        for (int an : ans) {
            if (n == an) {
                return true;
            }
        }
        return false;
    }

    private static boolean solve1(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        while (n >= 3) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                return false;
            }
        }
        return n== 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfThree(27));
        System.out.println(new Solution().isPowerOfThree(19684));
        System.out.println(new Solution().isPowerOfThree(45));

        // int num = 1;
        // while (num > 0) {
        //     num *= 3;
        //     System.out.print(num + ",");
        // }
    }
}