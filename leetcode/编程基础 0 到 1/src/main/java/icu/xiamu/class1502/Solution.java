package icu.xiamu.class1502;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/can-make-arithmetic-progression-from-sequence/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        return solve(arr);
    }

    private boolean solve(int[] arr) {
        Arrays.sort(arr);

        int gap = arr[1] - arr[0];

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1] - arr[i] != gap) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canMakeArithmeticProgression(new int[]{3, 5, 1}));
        System.out.println(new Solution().canMakeArithmeticProgression(new int[]{1, 2, 4}));
    }
}