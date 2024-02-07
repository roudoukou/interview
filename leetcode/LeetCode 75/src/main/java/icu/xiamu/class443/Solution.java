package icu.xiamu.class443;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int compress(char[] chars) {
        return solve2(chars);
    }

    private int solve2(char[] chars) {

        if (chars.length <= 1) {
            return chars.length;
        }

        int index = 0;
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (count == 1) { // 第一次
                chars[index++] = chars[i];
            }
            if (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                count++;
            } else {
                if (count != 1) {
                    // count maybe >= 100? > 10?
                    if (count < 10) {
                        chars[index++] = (char) (count + '0');
                    } else {
                        // 搞成字符数组 超市你 nnd
                        char[] countChars = String.valueOf(count).toCharArray();
                        for (char c : countChars) {
                            chars[index++] = c;
                        }
                    }
                }
                count = 1;
            }
        }

        return index;
    }

    /**
     * 不能采用map , ["a","a","a","b","b","a","a"] => ["a","5","b","2"] => 答案 ["a","3","b","2","a","2"]
     *
     * @param chars
     * @return
     */
    private int solve1(char[] chars) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        // 处理map
        StringBuilder stringBuilder = new StringBuilder();
        for (Character key : map.keySet()) {
            stringBuilder.append(key);
            if (map.get(key) != 1) {
                stringBuilder.append(map.get(key));
            }
        }

        // 仅仅只是改了一个引用地址
        // chars = stringBuilder.toString().toCharArray();
        // return chars.length;

        int length = stringBuilder.length();

        for (int i = 0; i < length; i++) {
            chars[i] = stringBuilder.charAt(i);
        }

        return length;
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().compress("aabbccc".toCharArray()));
        // System.out.println(new Solution().compress("a".toCharArray()));
        System.out.println(new Solution().compress("abbbbbbbbbbbb".toCharArray()));
    }
}