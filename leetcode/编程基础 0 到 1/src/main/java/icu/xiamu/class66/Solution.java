package icu.xiamu.class66;

import java.util.*;

/**
 * https://leetcode.cn/problems/plus-one/description/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public int[] plusOne(int[] digits) {
        return solve2(digits);
    }

    private int[] solve1(int[] digits) {
        // [9] => [1, 0]
        //         digits[digits.length-1]++;
        //         return digits;

        StringBuilder stringBuilder = new StringBuilder();
        for (int digit : digits) {
            stringBuilder.append(digit);
        }
        long value = Long.parseLong(stringBuilder.toString()); // long 会出现越界情况
        value++;

        List<Integer> list = new ArrayList<>();

        while (value != 0) {
            list.add((int) (value % 10));
            value /= 10;
        }

        Collections.reverse(list);
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        // list.stream().map(item -> Integer.parseInt(String.valueOf(item)))

        return array;
    }

    private int[] solve2(int[] digits) {

        int[] result = new int[digits.length + 1];
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i > 0 && digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1]++;
            }
            if (i == 0 && digits[i] == 10) {

                for (int j = 0; j < digits.length; j++) {
                    result[j + 1] = digits[j];
                }
                result[0] = 1;
                result[1] = 0;

                return result;
            }
        }

        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6})));
    }
}