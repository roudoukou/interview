package icu.xiamu.class1207;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        return solve1(arr);
    }

    private boolean solve1(int[] arr) {

        int count[] = new int[2200];

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 0) arr[i]+= 2000;
            count[arr[i]]++;
        }

        Arrays.sort(count);
        for (int i = 1; i < count.length; i++) {
            if (count[i-1] != 0 && count[i] != 0 && count[i-1] == count[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(new Solution().uniqueOccurrences(new int[]{1, 2}));
        System.out.println(new Solution().uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
        System.out.println(new Solution().uniqueOccurrences(new int[]{-1, 999}));
    }
}