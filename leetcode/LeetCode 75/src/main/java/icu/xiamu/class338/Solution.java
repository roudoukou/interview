package icu.xiamu.class338;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/counting-bits/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int[] countBits(int n) {
        return solve1(n);
    }

    private int[] solve1(int n) {
        int[] answer = new int[n + 1];
        for (int num = 0; num <= n; num++) {
            int count = 0;
            String string = Integer.toString(num, 2);
            for (char c : string.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }
            answer[num] = count;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countBits(2)));
        System.out.println(Arrays.toString(new Solution().countBits(5)));
    }
}