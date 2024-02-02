package icu.xiamu.class258;

/**
 * https://leetcode.cn/problems/add-digits/description/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public int addDigits(int num) {
        int ans = 0;
        while (num != 0) {
            int right = num % 10;
            num /= 10;
            ans += right;

            if (num == 0) {
                if (ans < 10) {
                    break;
                }
                num = ans;
                ans = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addDigits(38));
        System.out.println(new Solution().addDigits(0));
    }
}