package icu.xiamu.class2215;

import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return solve1(nums1, nums2);
    }

    private static List<List<Integer>> solve1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(i, nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            map2.put(i, nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (!map2.containsValue(map1.get(i))) {
                set1.add(map1.get(i));
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (!map1.containsValue(map2.get(i))) {
                set2.add(map2.get(i));
            }
        }

        return Arrays.asList(new ArrayList<>(set1), new ArrayList<>(set2));
    }

    public static void main(String[] args) {
        List<List<Integer>> difference = new Solution().findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6});
        System.out.println(difference);
        difference = new Solution().findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2});
        System.out.println(difference);
    }
}