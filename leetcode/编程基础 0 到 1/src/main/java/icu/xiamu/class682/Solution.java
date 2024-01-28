package icu.xiamu.class682;

class Solution {
    public int calPoints(String[] operations) {
        return solve1(operations);
    }

    private int solve1(String[] operations) {

        int [] result  = new int[operations.length];
        int index = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].contains("C")) {
                result[index--] = 0;
            } else if (operations[i].contains("D")) {
                result[index] = 2 * result[index - 1];
                index++;
            } else if (operations[i].contains("+")) {
                result[index] = result[index - 2] + result[index - 1];
                index++;
            } else {
                int numValue = Integer.parseInt(operations[i]);
                result[index++] = numValue;
            }
        }

        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += result[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calPoints(new String[]{"5", "2", "C", "D", "+"})); // 30
        System.out.println(new Solution().calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"})); // 27
        System.out.println(new Solution().calPoints(new String[]{"1"})); // 1
    }
}