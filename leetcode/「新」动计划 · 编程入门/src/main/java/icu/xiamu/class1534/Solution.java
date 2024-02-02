package icu.xiamu.class1534;

/**
 * https://leetcode.cn/problems/count-good-triplets/submissions/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        return solve1(arr, a, b, c);
    }

    private int solve1(int[] arr, int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1));
        System.out.println(new Solution().countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
    }
}