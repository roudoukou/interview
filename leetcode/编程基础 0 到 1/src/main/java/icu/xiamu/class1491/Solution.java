package icu.xiamu.class1491;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/average-salary-excluding-the-minimum-and-maximum-salary/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public double average(int[] salary) {
        return solve1(salary);
    }

    private double solve1(int[] salary) {
        Arrays.sort(salary);

        double result = 0;
        for (int i = 1; i <= salary.length - 2; i++) {
            result += salary[i];
        }

        return result / (salary.length - 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().average(new int[]{4000, 3000, 1000, 2000}));
    }
}