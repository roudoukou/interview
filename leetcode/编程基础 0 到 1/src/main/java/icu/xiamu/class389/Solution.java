package icu.xiamu.class389;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/find-the-difference/description/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public char findTheDifference(String s, String t) {
        return solve1(s, t);
    }

    private char solve1(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), 1);
            } else {
                Integer value = map1.get(s.charAt(i));
                map1.put(s.charAt(i), value+1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), 1);
            } else {
                Integer value = map2.get(t.charAt(i));
                map2.put(t.charAt(i), value+1);
            }
        }


        for (char i = 'a'; i <= 'z'; i++) {
            if (map1.get(i) != map2.get(i)) {
                return i;
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findTheDifference("abcd", "abcde") == 'e');
        System.out.println(new Solution().findTheDifference("", "y") == 'y');
    }
}