package icu.xiamu.code5;

/**
 * 11. 盛最多水的容器
 * <a href="https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public int maxArea(int[] height) {
        // return process1(height);
        return process2(height);
    }

    /**
     * 双指针
     * @param height 高度
     * @return 结果
     */
    private int process2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = Integer.MIN_VALUE;
        while (left < right) {

            result = Math.max(result, (right - left) * Math.min(height[right], height[left]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    /**
     * 大力出奇迹的方式, 代码超时
     * @param height 数组
     * @return 答案
     */
    private static int process1(int[] height) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
            // for (int j = i + 1; j < height.length; j++) {
            for (int j = height.length - 1; j >= i + 1; j--) {
                result = Math.max(result, (j - i) * Math.min(height[j], height[i]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new Solution().maxArea(new int[]{1, 1}));
    }
}