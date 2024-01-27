package icu.xiamu.class1041;

/**
 * https://leetcode.cn/problems/robot-bounded-in-circle/submissions/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public boolean isRobotBounded(String instructions) {
        // head 0 北 1 东 2 南 3 西
        int head = 0;
        int x = 0;
        int y = 0;

        // 暴力遍历十次
        for (int i = 1; i <= 10; i++) {
            int[] ints = solve1(instructions, head, x, y);
            head = ints[0];
            x = ints[1];
            y = ints[2];
            if (x == 0 && y == 0) {
                return true;
            }
        }
        return false;
    }

    private int[] solve1(String instructions, int head, int x, int y) {
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                head--;
                head = (head + 4) % 4;
            }
            if (instructions.charAt(i) == 'R') {
                head++;
                head = head % 4;
            }
            if (instructions.charAt(i) == 'G') {
                // 移动
                int[] ints = moveHead(head, x, y);
                x = ints[0];
                y = ints[1];
            }
        }
        return new int[] {head, x, y};
    }

    private int[] moveHead(int head, int x, int y) {
        if (head == 0) {
            x = x;
            y = y + 1;
        } else if (head == 1) {
            x = x + 1;
            y = y;
        } else if (head == 2) {
            x = x;
            y = y - 1;
        } else if (head == 3) {
            x = x - 1;
            y = y;
        }

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isRobotBounded("GGLLGG"));
        System.out.println(new Solution().isRobotBounded("GG"));
        System.out.println(new Solution().isRobotBounded("GL"));
    }
}