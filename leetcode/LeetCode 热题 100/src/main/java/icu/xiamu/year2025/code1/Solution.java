package icu.xiamu.year2025.code1;

import io.github.jidcoo.opto.lcdb.enhancer.LeetcodeJavaDebugEnhancer;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

class Solution extends LeetcodeJavaDebugEnhancer {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}