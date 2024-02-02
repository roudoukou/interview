package icu.xiamu.class1281;

/**
 * https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer/description/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public int subtractProductAndSum(int n) {
        int a = n / 10000 % 10;
        int b = n / 1000  % 10;
        int c = n / 100   % 10;
        int d = n / 10    % 10;
        int e = n / 1     % 10;

        if (a > 0) return (a * b * c * d * e) - (a + b + c + d + e);
        if (b > 0) return (b * c * d * e)     - (b + c + d + e);
        if (c > 0) return (c * d * e)         - (c + d + e);
        if (d > 0) return (d * e)             - (d + e);
        if (e > 0) return e - e;


        int mul = a * b * c * d * e;
        int sum = a + b + c + d + e;
        return mul - sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subtractProductAndSum(705));
        System.out.println(new Solution().subtractProductAndSum(234));
    }
}