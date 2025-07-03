package icu.xiamu.year2023.class15;

import java.util.*;

/**
 * https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return solve1(nums);
    }

    /**
     * 暴力遍历算法 O(n^3) 超时了...
     * @param nums
     * @return
     */
    private List<List<Integer>> solve1(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if ((nums[i] > 0 && nums[j] > 0 && nums[k] > 0) || (nums[i] < 0 && nums[j] < 0 && nums[k] < 0) ) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        if (!ans.contains(list)) {
                            // 让 nums[i], nums[j], nums[k] 有序
                            ans.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new Solution().threeSum(new int[]{0, 1, 1}));
        System.out.println(new Solution().threeSum(new int[]{0, 0, 0}));
    }
}