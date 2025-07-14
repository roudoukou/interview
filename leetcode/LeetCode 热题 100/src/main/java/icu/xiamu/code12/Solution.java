package icu.xiamu.code12;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * <a href="https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public String minWindow(String s, String t) {
        // return process1(s, t);
        // return process2(s, t);
        return process3(s, t);
    }

    /**
     * 双指针，哈希法
     * @param s s
     * @param t t
     * @return 结果
     */
    private String process3(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // letter1 (更名为 needs): 存储 t 中每个字符所需数量 (目标字符频率)
        Map<Character, Integer> needs = new HashMap<>();
        for (char c : t.toCharArray()) { // 遍历 t 的字符数组
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        // letter2 (更名为 window): 存储当前滑动窗口中每个字符的计数 (窗口内字符频率)
        Map<Character, Integer> window = new HashMap<>();

        int left = 0; // 滑动窗口左边界
        int right = 0; // 滑动窗口右边界，指向当前要加入窗口的字符

        // validCount 统计当前窗口中，有多少个 t 中所需的字符已经被“有效”匹配
        // 例如 t="AABC"，当窗口中有 A=2, B=1, C=1 时，validCount 达到 4
        int validCount = 0;

        int minLength = Integer.MAX_VALUE; // 最小窗口的长度
        int minStart = 0; // 最小窗口的起始索引

        while (right < s.length()) {
            char charR = s.charAt(right); // 当前要加入窗口的字符

            // 将 charR 加入窗口，并更新 window Map
            window.put(charR, window.getOrDefault(charR, 0) + 1);

            // 如果 charR 是 t 中需要的字符 (needs 中存在)，并且 window 中 charR 的数量
            // 小于等于 needs 中 charR 的所需数量，那么它就是一次有效匹配，validCount 增加
            // 注意：这里需要先检查 needs.containsKey(charR)，因为只有 t 中存在的字符才需要计数
            if (needs.containsKey(charR) && window.get(charR) <= needs.get(charR)) {
                validCount++;
            }

            right++; // 窗口右边界向右移动

            // 核心的收缩逻辑：当 validCount 达到 t.length() 时，说明当前窗口包含所有 t 中的字符了
            while (validCount == t.length()) {
                // 1. 检查并更新最小窗口长度
                if (right - left < minLength) {
                    minLength = right - left;
                    minStart = left;
                }

                char charL = s.charAt(left); // 将要移出窗口的字符

                // 如果 charL 是 t 中需要的字符
                // 并且 charL 移出窗口后，会导致其数量不再满足 t 的要求
                if (needs.containsKey(charL) && window.get(charL) <= needs.get(charL)) {
                    validCount--; // 有效匹配数减少
                }
                window.put(charL, window.get(charL) - 1); // 窗口中该字符计数减少

                left++; // 窗口左边界向右移动
            }
        }

        // 如果 minLength 仍然是初始值，表示没有找到符合条件的子串
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    /**
     * 数组滑动窗口, 双指针
     * @param s s
     * @param t t
     * @return 结果
     */
    private String process2(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int min = Integer.MAX_VALUE;
        int minL = 0, minR = 0, left = 0, right = 0, count = 0;
        int[] letter1 = new int[128];
        int[] letter2 = new int[128];

        for (int i = 0; i < t.length(); i++) {
            letter1[t.charAt(i)]++;
        }

        while (right < s.length()) {

            char rightChar = s.charAt(right);
            if (letter1[rightChar] > 0) {
                letter2[rightChar]++;

                if (letter2[rightChar] <= letter1[rightChar]) {
                    count++;
                }
            }

            right++;

            while (count == t.length()) {
                if (right - left < min) {
                    min = right - left;
                    minL = left;
                    minR = right;
                }

                char leftChar = s.charAt(left);
                left++;
                if (letter1[leftChar] > 0) {
                    if (letter2[leftChar] <= letter1[leftChar]) {
                        count--;
                    }
                    letter2[leftChar]--;
                }
            }
        }


        return min == Integer.MAX_VALUE ? "" : s.substring(minL, minR);
    }

    private static String process1(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // 注意：这里移除 Objects.equals(s, t) 的特判，因为通用逻辑可以处理
        // if (Objects.equals(s, t)) {
        //     return s;
        // }

        // letter1 存储 t 中每个字符所需数量 (目标字符频率)
        // 使用 128 或 256 大小数组可以覆盖所有 ASCII 字符
        int[] letter1 = new int[128];
        for (int i = 0; i < t.length(); i++) {
            letter1[t.charAt(i)]++; // 直接使用 char 作为索引
        }

        // letter2 存储当前滑动窗口中每个字符的计数 (窗口内字符频率)
        int[] letter2 = new int[128];
        // 无需 Arrays.copyOf(letter1, letter1.length); 这里 letter2 应该从全 0 开始

        int min = Integer.MAX_VALUE; // 最小窗口的长度
        int minL = 0; // 最小窗口的起始索引
        int minR = 0; // 最小窗口的结束索引 (不包含)

        // validCount 统计当前窗口中，满足 t 中所需字符的总数量
        // 例如 t = "AABC"，A需要2个，B需要1个，C需要1个，那么 validCount 达到 4 才算有效
        int validCount = 0;

        int left = 0;
        int right = 0; // right 作为窗口的右边界，指向当前要加入窗口的字符

        while (right < s.length()) {
            char charR = s.charAt(right); // 当前要加入窗口的字符

            // 如果 charR 是 t 中需要的字符 (即 letter1 中对应计数大于 0)
            if (letter1[charR] > 0) {
                letter2[charR]++; // 窗口中该字符计数增加

                // 如果当前窗口中 charR 的数量，还没有超过 t 所需的数量
                // 那么它就是有效匹配，validCount 增加
                if (letter2[charR] <= letter1[charR]) {
                    validCount++;
                }
            }

            right++; // 窗口右边界向右移动

            // 核心的收缩逻辑：当 validCount 达到 t.length() 时，说明当前窗口包含所有 t 中的字符了
            while (validCount == t.length()) {
                // 1. 检查并更新最小窗口长度
                if (right - left < min) {
                    min = right - left;
                    minL = left;
                    minR = right; // minR 是 substring 的独占结束索引
                }

                char charL = s.charAt(left); // 将要移出窗口的字符
                left++; // 窗口左边界向右移动

                // 如果 charL 是 t 中需要的字符
                if (letter1[charL] > 0) {
                    // 如果 charL 移出窗口后，导致其数量少于 t 所需，那么有效匹配数减少
                    if (letter2[charL] <= letter1[charL]) {
                        validCount--;
                    }
                    letter2[charL]--; // 窗口中该字符计数减少
                }
            }
        }

        // 如果 min 仍然是初始值，表示没有找到符合条件的子串
        return min == Integer.MAX_VALUE ? "" : s.substring(minL, minR);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("a", "a"));
        System.out.println(new Solution().minWindow("a", "aa"));
        System.out.println(new Solution().minWindow("bbccdada", "aa"));
        System.out.println(new Solution().minWindow("a", "b"));
        System.out.println(new Solution().minWindow("ab", "A"));
        System.out.println(new Solution().minWindow("bdab", "ab"));
        System.out.println(new Solution().minWindow("bba", "ab"));
    }
}