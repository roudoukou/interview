package icu.xiamu.class657;

/**
 * https://leetcode.cn/problems/robot-return-to-origin/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public boolean judgeCircle(String moves) {
        return solve1(moves);
    }

    private boolean solve1(String moves) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                x = x - 1;
                y = y;
            } else if (moves.charAt(i) == 'U') {
                x = x;
                y = y + 1;
            } else if (moves.charAt(i) == 'R') {
                x = x + 1;
                y = y;
            } else if (moves.charAt(i) == 'D') {
                x = x;
                y = y - 1;
            }
        }

        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().judgeCircle("UD"));
        System.out.println(new Solution().judgeCircle("LL"));
    }
}