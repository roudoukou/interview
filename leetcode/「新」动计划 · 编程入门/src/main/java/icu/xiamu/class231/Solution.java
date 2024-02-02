package icu.xiamu.class231;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/power-of-two/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        int[] answer = new int[]{2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, 2147483647};
        Set<Integer> set = Arrays.stream(answer).boxed().collect(Collectors.toSet());
        return set.contains(n);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(5));

        // int ans = 1;
        // System.out.print("{");
        // for (int i = 0; i < 31; i++) {
        //     ans *= 2;
        //     System.out.print(ans + ",");
        // }
        // System.out.print("}");
        // System.out.println();
    }
}