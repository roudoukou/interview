package icu.xiamu.class238;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        return solve2(nums);
    }

    /**
     * 暴力出奇迹, 貌似暴力超时? 上缓存表
     * @param nums
     * @return
     */
    private int[] solve2(int[] nums) {
        int [] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ans[i] = map.get(nums[i]);
            } else for (int j = 0; j < nums.length; j++) {
                if ( i != j ) {
                    ans[i] *= nums[j];
                    map.put(nums[i], ans[i]);
                }
            }
        }
        return ans;
    }

    /**
     * 好像总有两个特殊值 太奇葩了
     * @param nums
     * @return
     */
    private int[] solve1(int[] nums) {

        int mul1 = 1;  // 包含0的乘积
        int mul2 = 1;  // 不包含0的乘积
        for (int num : nums) {
            mul1 *= num;
            if (num != 0) {
                mul2 *= num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = mul2;
            } else {
                nums[i] = mul1 / nums[i];
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4}))); // [24, 12, 8, 6]
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{-1, 1, 0, -3, 3}))); // [0, 0, 9, 0, 0]
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{0, 0}))); //
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 0}))); //
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{0, 1}))); //
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 1}))); //
    }
}