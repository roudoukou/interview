package main.java.class448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        HashSet<Integer> set = new HashSet<>(Arrays.asList(array));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(i+1)) {
                result.add(i+1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(new Solution().findDisappearedNumbers(new int[]{1, 1}));
    }
}