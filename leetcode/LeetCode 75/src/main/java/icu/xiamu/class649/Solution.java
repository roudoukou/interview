package icu.xiamu.class649;

import java.util.*;

/**
 * https://leetcode.cn/problems/dota2-senate/submissions/500563426/?envType=study-plan-v2&envId=leetcode-75
 *
 * 大致题意就是 , D可以干掉身后的一个R, R可以干掉身后的一个D, 每一轮只能干掉一个
 * 每次当D干掉后面的, 将D出队再入队
 * 每次当R干掉后面的, 将R出队再入队
 *
 */
class Solution {
    public String predictPartyVictory(String senate) {
        return solve1(senate);
    }

    private String solve1(String senate) {
        char[] chars = senate.toCharArray();
        Queue<Character> queue = new LinkedList<>();

        for (char c : chars) {
            queue.offer(c);
        }

        // while (!queue.isEmpty()) {
        for (char c : chars) {
            Character element = queue.element();
            if (element == 'D') {
                queue.remove('R');
                queue.offer(queue.poll());
            } else {
                queue.remove('D');
                queue.offer(queue.poll());

            }
        }

        return queue.element() == 'D' ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().predictPartyVictory("DRRD"));
        // System.out.println(new Solution().predictPartyVictory("RD"));
        System.out.println(new Solution().predictPartyVictory("RDD")); // Dire
        System.out.println(new Solution().predictPartyVictory("DDRRR"));
    }
}