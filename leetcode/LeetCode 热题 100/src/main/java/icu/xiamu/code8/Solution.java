package icu.xiamu.code8;

/**
 * 3. 无重复字符的最长子串
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int length = s.length();

        StringBuilder sb = new StringBuilder();
        int result = 0;

        while (right < length) {
            char current = s.charAt(right);
            int indexOf = sb.indexOf(String.valueOf(current));
            if (indexOf != -1) {
                String substring = sb.substring(indexOf + 1, sb.length());
                sb.setLength(0);
                sb.append(substring);
                sb.append(current);
                // sb.append(s, indexOf, s.length()-1);
            } else {
                sb.append(current);
            }
            right++;
            result = Math.max(result, sb.length());
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}