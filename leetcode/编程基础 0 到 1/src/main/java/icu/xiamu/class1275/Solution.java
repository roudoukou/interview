package icu.xiamu.class1275;

/**
 * https://leetcode.cn/problems/find-winner-on-a-tic-tac-toe-game/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public String tictactoe(int[][] moves) {
        return solve1(moves);
    }

    private String solve1(int[][] moves) {
        int[][] dp = new int[3][3];
        // A => 6
        // B => 9
        for (int step = 0; step < moves.length; step++) {
            // System.out.print(moves[step][0] + "\t" + moves[step][1] + "\n");
            if (((step+1) & 1) != 0) { // 奇数
                dp[moves[step][0]][moves[step][1]] = 6;
            } else {
                dp[moves[step][0]][moves[step][1]] = 9;
            }
        }

        for (int i = 0; i < 3; i++) {
            // 横线
            if (dp[i][0] == dp[i][1] && dp[i][1] == dp[i][2]) {
                return dp[i][0] == 6 ? "A" : (dp[i][0] == 9 ? "B" : "Pending");
            }

            // 竖线
            if (dp[0][i] == dp[1][i] && dp[1][i] == dp[2][i]) {
                return dp[0][i] == 6 ? "A" : (dp[0][i] == 9 ? "B" : "Pending");
            }
        }

        // 对角线
        if (dp[0][0] == dp[1][1] && dp[1][1] == dp[2][2]) {
            return dp[0][0] == 6 ? "A" : (dp[0][0] == 9 ? "B" : "Pending");
        }

        if (dp[0][2] == dp[1][1] && dp[1][1] == dp[2][0]) {
            return dp[0][2] == 6 ? "A" : (dp[0][2] == 9 ? "B" : "Pending");
        }

        // 判断是否玩不下去了...
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (dp[i][j] != 0) {
                    count++;
                }
            }
        }

        if (count == 9) {
            return "Draw";
        }

        return "Pending";
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().tictactoe(new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}}));
        // System.out.println(new Solution().tictactoe(new int[][]{{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}}));
        System.out.println(new Solution().tictactoe(new int[][]{{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}}));
        // System.out.println(new Solution().tictactoe(new int[][]{{0, 0}, {1, 1}}));
        System.out.println(new Solution().tictactoe(new int[][]{{1, 1}, {2, 0}, {0, 2}}));
    }
}