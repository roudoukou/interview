package icu.xiamu.class374;

import java.util.Random;

/**
 * https://leetcode.cn/problems/guess-number-higher-or-lower/?envType=study-plan-v2&envId=leetcode-75
 * <p>
 * Forward declaration of guess API.
 *
 * @param num your guess
 * @return -1 if num is higher than the picked number
 * 1 if num is lower than the picked number
 * otherwise return 0
 * int guess(int num);
 */

abstract class GuessGame {
    abstract int guess(int num);
}

public class Solution extends GuessGame {
    static Random random = new Random();
    static int pick = 0;

    public int guessNumber(int n) {
        return solve1(1, n);
    }

    private int solve1(int left, int right) {
        while (left <= right) {
            // int mid = (left + right) / 2;
            int mid = left + ((right - left) >> 1); // 防止溢出
            int guess = guess(mid);
            if (guess == 0) return mid;
            else if (guess == -1) { // 大了
                right = mid - 1;
            } else if (guess == 1) {
                left = mid + 1;
            }
        }
        return right - left + 1;
    }

    @Override
    public int guess(int num) {
        pick = 1702766719;
        if (pick < num) {
            return -1;
        } else if (pick > num) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().guessNumber(10));
        // System.out.println(new Solution().guessNumber(2));
        System.out.println(new Solution().guessNumber(2126753390));
    }
}