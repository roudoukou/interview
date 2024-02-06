package icu.xiamu.class17;

import java.util.*;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * 参考的代码随想录的视频, 写是写出来了, 但还是懵懵懂懂的 https://www.bilibili.com/video/BV1yV4y1V7Ug
 */
class Solution {
    Map<Integer, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        process(digits, 0);
        return result;
    }

    private void process(String digits, int index) {

        if (index == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        String s = map.get(digits.charAt(index) - '0');
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            process(digits, index+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
        System.out.println(new Solution().letterCombinations(""));
        System.out.println(new Solution().letterCombinations("2"));
    }
}