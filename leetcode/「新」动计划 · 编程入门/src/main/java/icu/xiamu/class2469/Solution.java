package icu.xiamu.class2469;

/**
 * https://leetcode.cn/problems/convert-the-temperature/description/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public double[] convertTemperature(double celsius) {

        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}