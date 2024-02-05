package icu.xiamu.class1422;

/**
 * https://leetcode.cn/problems/maximum-score-after-splitting-a-string/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public int maxScore(String s) {
        return solve1(s);
    }

    private int solve1(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            ans = Math.max(ans, count(s.substring(0, i), '0') + count(s.substring(i), '1'));
        }
        return ans;
    }

    private int count(String s, char c) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxScore("011101"));
        System.out.println(new Solution().maxScore("00111"));
        System.out.println(new Solution().maxScore("1111"));
    }
}