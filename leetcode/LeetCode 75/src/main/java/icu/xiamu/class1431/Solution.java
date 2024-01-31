package icu.xiamu.class1431;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        return solve1(candies, extraCandies);
    }

    private List<Boolean> solve1(int[] candies, int extraCandies) {
        int maxValue = Integer.MIN_VALUE;
        for (int i =0; i < candies.length; i++) {
            if (maxValue < candies[i]) {
                maxValue = candies[i];
            }
        }

        List<Boolean> answer = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxValue) {
                answer.add(true);
            } else {
                answer.add(false);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        List<Boolean> booleans = new Solution().kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3);
        System.out.println(booleans.toString());
        booleans = new Solution().kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1);
        System.out.println(booleans.toString());
        booleans = new Solution().kidsWithCandies(new int[]{12, 1, 12}, 10);
        System.out.println(booleans.toString());
    }
}