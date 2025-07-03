package icu.xiamu.year2023.class17;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {

    /**
     * 2024-2-16 12:38:40
     */
    Map<Character, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.contains("1") || digits.length() == 0) {
            return result;
        }

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        process(digits,0);
        return result;
    }

    private void process(String digits, int index) {

        if (path.length() == digits.length()) {
            result.add(path.toString());
            return;
        }

        for (int i = index; i < digits.length(); i++) {
            // System.out.println(map.get(digits.charAt(i)));
            String str = map.get(digits.charAt(i));
            for (int j = 0; j < str.length(); j++) {
                path.append(str.charAt(j));
                process(digits, i+1);
                path.deleteCharAt(path.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
        System.out.println(new Solution().letterCombinations(""));
        System.out.println(new Solution().letterCombinations("2"));
    }



/*
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
*/
}   