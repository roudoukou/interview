package icu.xiamu;

import java.util.HashMap;
import java.util.Map;

public class BM51 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int MoreThanHalfNum_Solution(int[] numbers) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                Integer integer = map.get(numbers[i]);
                map.put(numbers[i], integer + 1);
            } else {
                map.put(numbers[i], 1);
            }
        }

        int max = Integer.MIN_VALUE;
        int maxKey = 0;
        for (Integer integer : map.keySet()) {
            int value = map.get(integer);
            if (max < value) {
                max = value;
                maxKey = integer;
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int result = new BM51().MoreThanHalfNum_Solution(numbers);
        System.out.println(result);
    }
}
