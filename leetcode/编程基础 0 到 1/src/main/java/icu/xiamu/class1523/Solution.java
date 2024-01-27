package icu.xiamu.class1523;


/**
 * https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public int countOdds(int low, int high) {
        return solve1(low, high);
    }

    private int solve1(int low, int high) {
        int count = 0;
        for (int index = low ; index <= high; index++) {
            if ((index & 1) != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countOdds(3, 7));
        System.out.println(new Solution().countOdds(8, 10));
    }
}