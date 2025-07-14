package icu.xiamu.code11;

import io.netty.util.internal.DefaultPriorityQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 239. 滑动窗口最大值
 * <a href="https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        // return process1(nums, k);
        return process2(nums, k);
    }

    private int[] process2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {

            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - (k - 1)] = nums[deque.peekFirst()];
            }
        }


        return result;
    }

    /**
     * 暴力
     * @param nums 数组
     * @param k k
     * @return 结果
     */
    private static int[] process1(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int left = i;
            int right = left + k;
            int max = Integer.MIN_VALUE;
            for (int current = left; current < right; current++) {
                max = Math.max(max, nums[current]);
                result[i] = max;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1, -1}, 1)));
    }
}