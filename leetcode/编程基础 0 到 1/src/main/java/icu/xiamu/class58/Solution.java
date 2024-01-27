package icu.xiamu.class58;

/**
 * https://leetcode.cn/problems/length-of-last-word/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public int lengthOfLastWord(String s) {
        return solve1(s);
    }

    private int solve1(String s) {
        String[] split = s.trim().split(" ");
        return split[split.length - 1].length();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("Hello World"));
        System.out.println(new Solution().lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(new Solution().lengthOfLastWord("luffy is still joyboy"));
    }

}