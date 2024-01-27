package icu.xiamu.class860;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/lemonade-change/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        return solve1(bills);
    }

    private boolean solve1(int[] bills) {
        // Arrays.sort(bills);

        int money5 = 0;
        int money10 = 0;
        int money20 = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                money5++;
            } else if (bills[i] == 10) {
                money10++;
            } else if (bills[i] == 20) {
                money20++;
            }


            while (bills[i] != 5) {
                if (bills[i] == 20 || bills[i] == 15) {
                    if (money10 > 0) {
                        money10--;
                        bills[i] -= 10;
                    } else if (money5 > 0){
                        money5--;
                        bills[i] -= 5;
                    } else {
                        return false;
                    }
                }
                if (bills[i] == 10) {
                    if (money5 > 0) {
                        money5--;
                        bills[i] -= 5;
                    } else {
                        return false;
                    }
                }
            }
        }

        if (money5 < 0 || money10 < 0) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lemonadeChange(new int[]{5, 5, 5, 10, 20})); // true
        System.out.println(new Solution().lemonadeChange(new int[]{5, 5, 10, 10, 20})); // false
        System.out.println(new Solution().lemonadeChange(new int[]{5, 5, 20, 5, 5, 10, 5, 10, 5, 20})); // false
        System.out.println(new Solution().lemonadeChange(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5})); // true
    }
}