package icu.xiamu.year2023.class169;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 169. 多数元素
 * https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    public int majorityElement(int[] nums) {
        return solve1(nums);
    }

    private int solve1(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > nums.length/2) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new Solution().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}