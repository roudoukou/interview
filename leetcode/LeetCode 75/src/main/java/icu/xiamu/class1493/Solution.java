package icu.xiamu.class1493;

/**
 * https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int longestSubarray(int[] nums) {
        return solve2(nums);
    }

    // 直接使用left++来更新滑动窗口
    private int solve2(int[] nums) {

        int ans = Integer.MIN_VALUE;
        int zeroCount = 0; // 表示滑动窗口中存在几个零
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;

                while (zeroCount == 2) {
                    if (nums[left++] == 0) {
                        zeroCount--;
                    }
                }
            }
            ans = Math.max(ans, right - left);
        }

        return ans;
    }

    // 通过记录上一次零的坐标, 缩短滑动窗口
    // 使用滑动窗口, 窗口中最多保存一个0
    // 0 1 1 1 0 1 1 0 1
    // 0                left = 0; right++; 1个0
    // 0 1 1 1 0        if nums[left] = 0 left++; zeroCount--;; right++;  else right++;
    // 1 1 1 0 1 1 0    left = 第一个零的位置 + 1 right++;
    private int solve1(int[] nums) {

        int ans = Integer.MIN_VALUE;

        int zeroIndex = 0;
        int zeroCount = 0; // 窗口中零的个数
        for (int left = 0, right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;

                if (zeroCount == 1) {
                    zeroIndex = right; // 第一个零的位置
                }
                if (zeroCount == 2) {  // 第二个零的位置
                    zeroCount--;
                    left = zeroIndex+1;
                    zeroIndex = right; // 更新当前零的位置 , 当前零作为第一个零的位置
                }
            }

            ans = Math.max(ans, right - left);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1})); // 5
        System.out.println(new Solution().longestSubarray(new int[]{1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1})); // 11
        System.out.println(new Solution().longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1})); // 4
        System.out.println(new Solution().longestSubarray(new int[]{1, 1, 0, 1})); // 3
        System.out.println(new Solution().longestSubarray(new int[]{1, 1, 1})); // 2

        // b = 1
        // a = b++
    }
}