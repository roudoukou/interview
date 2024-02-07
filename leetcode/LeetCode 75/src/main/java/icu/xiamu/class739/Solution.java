package icu.xiamu.class739;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        return solve2(temperatures);
    }

    private int[] solve2(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {

            // 栈顶是否比我大, 比我大 ? 栈顶出栈 当前节点入栈
            // 比我小? 栈顶不动, 当前节点入栈

            Integer top = 0;
            if (!stack.isEmpty()) {
                top = stack.indexOf(stack.peek());
            }
            while (!stack.isEmpty() && temperatures[i] < temperatures[top]) {
                Integer pop = stack.pop();
                answer[i] = temperatures[top] - temperatures[i];
            }
            stack.push(temperatures[i]);
        }

        return answer;
    }

    /**
     * 暴力遍历, 最终超时
     *
     * @param temperatures 温度数组
     * @return 答案
     */
    private int[] solve1(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{30, 60, 90})));
    }
}