package icu.xiamu.lcr.class260;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/single-number-iii/
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        return solve1(nums);
    }

    private int[] solve1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // return map.values().stream().filter(data -> data == 1).mapToInt(Integer::intValue).toArray();
        return map.entrySet().stream().filter(entry -> entry.getValue() == 1).mapToInt(entry -> entry.getKey()).toArray();
    }
}