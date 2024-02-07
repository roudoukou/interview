package icu.xiamu.class2542;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.cn/problems/maximum-subsequence-score/solutions/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    Long ans = Long.MIN_VALUE;
    List<Integer> path = new ArrayList<>();

    public long maxScore(int[] nums1, int[] nums2, int k) {
        // process(nums1, nums2, k, 0);
        // return ans;
        return solve1(nums1, nums2, k);
    }

    private long solve1(int[] nums1, int[] nums2, int k) {

        for (int i = 0; i < nums2.length-1; i++) {
            for (int j = i+1; j < nums2.length; j++) {
                if (nums2[i] < nums2[j]) {
                    int temp = nums2[i];
                    nums2[i] = nums2[j];
                    nums2[j] = temp;

                    temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }

        long sum = 0;
        long min = Long.MAX_VALUE;
        long ans = 0;
        for (int j = 0; j < nums2.length; j++) {
            for (int i = j; i < (Math.min(j + k, nums1.length)); i++) {
                sum += nums1[i];
                min = Math.min(min, nums2[i]);
            }
            ans = Math.max(ans, sum * min);
            sum = 0;
            min = Long.MAX_VALUE;
        }
        return ans;
    }


    /**
     * 回溯暴力搜索, 会超时
     *
     * @param nums1
     * @param nums2
     * @param k
     * @param index
     */
    private void process(int[] nums1, int[] nums2, int k, int index) {
        if (path.size() == k) {
            // System.out.println(path);
            int[] array = path.stream().mapToInt(Integer::intValue).toArray();
            int sum = 0;
            for (int i : array) {
                sum += nums1[i];
            }

            int minValue = Integer.MAX_VALUE;
            for (int i : array) {
                minValue = Math.min(minValue, nums2[i]);
            }

            ans = Math.max(ans, (long) sum * minValue);

            return;
        }
        for (int i = index; i < nums1.length; i++) {
            path.add(i);
            process(nums1, nums2, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxScore(new int[]{2, 1, 14, 12}, new int[]{11, 7, 13, 6}, 3)); // 168
        System.out.println(new Solution().maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3));
        System.out.println(new Solution().maxScore(new int[]{4, 2, 3, 1, 1}, new int[]{7, 5, 10, 9, 6}, 1));
    }
}