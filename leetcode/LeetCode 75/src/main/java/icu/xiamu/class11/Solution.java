package icu.xiamu.class11;

/**
 * https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int maxArea(int[] height) {
        return solve1(height);
    }

    private int solve1(int[] height) {
        int left = 0;
        int right = height.length-1;
        int answer = Integer.MIN_VALUE;

        while (left <= right) {

            // 1,8,6,2,5,4,8,3,7
            //  1 2 3 4 5 6 7 8
            int wid = right - left;
            int hei = Math.min(height[left], height[right]);
            int square = wid * hei;
            answer = Math.max(answer, square);

            // 抛弃矮的
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new Solution().maxArea(new int[]{1, 1}));
    }
}