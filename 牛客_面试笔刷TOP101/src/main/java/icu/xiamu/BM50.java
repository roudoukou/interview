package icu.xiamu;

import java.util.HashMap;

public class BM50 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * https://www.nowcoder.com/exam/oj
     * https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=295&tqId=745&ru=/exam/company&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Fcompany
     *
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public int[] twoSum(int[] numbers, int target) {
        // write code here
        return find2(numbers, target);
    }

    /**
     * 采用减法, 然后查找
     *
     * @param numbers
     * @param target
     * @return
     */
    private int[] find2(int[] numbers, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // 查找a
        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(numbers[i])) {
                Integer result1 = hashMap.get(numbers[i]);
                // Integer result2 = hashMap.get(target - numbers[i]);
                // System.out.println("result1 = " + (result1+1));
                // System.out.println("result2 = " + (result2+1));
                return new int[]{(result1 + 1), (i + 1)};
            } else {
                numbers[i] = target - numbers[i];
                hashMap.put(numbers[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 暴力遍历, 测试用例通过7/12
     *
     * @param numbers
     * @param target
     * @return
     */
    private int[] find1(int[] numbers, int target) {
        int length = numbers.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        // a + b = target
        // a = target - b
        int[] numbers = {3, 2, 4};
        int target = 6;
        // int[] numbers = {20, 70, 110, 150};
        // int target = 90;
        // int[] numbers = {0, 4, 3, 0};
        // int target = 0;
        int[] ints = new BM50().twoSum(numbers, target);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
