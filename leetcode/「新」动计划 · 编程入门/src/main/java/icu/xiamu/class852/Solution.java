package icu.xiamu.class852;

/**
 * https://leetcode.cn/problems/peak-index-in-a-mountain-array/description/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        return solve1(arr);
    }

    private int solve1(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(new Solution().peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(new Solution().peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
    }
}