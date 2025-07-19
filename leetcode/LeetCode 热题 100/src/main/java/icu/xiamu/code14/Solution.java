package icu.xiamu.code14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * <a href="https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        // return process1(intervals);
        return process2(intervals);
    }

    /**
     * 直接把第一个加入结果
     * @param intervals 间隔数组
     * @return 结果
     */
    private int[][] process2(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastMergedInterval = result.getLast();
            if (currentInterval[0] <= lastMergedInterval[1]) {
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]);
            } else {
                result.add(currentInterval);
            }
        }


        return result.toArray(new int[result.size()][]);
    }

    private static int[][] process1(int[][] intervals) {
        int[] point = new int[10005];
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            max = Math.max(right, max);
            for (int j = left; j <= right; j++) {
                point[j] = 1;
            }
        }

        List<Integer[]> result = new ArrayList<>();

        for (int i = 0; i <= max; i++) {
            int left = Integer.MAX_VALUE;
            int right = Integer.MIN_VALUE;
            while (point[i] == 1) {
                left = Math.min(i, left);
                right = Math.max(i, right);
                i++;
            }
            if (left != Integer.MAX_VALUE) {
                result.add(new Integer[]{left, right});
            }
        }
        return result.stream().map(integerArray -> Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.toString(new Solution().merge(new int[][]{{1, 4}, {4, 5}})));
    }
}