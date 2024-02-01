package icu.xiamu.class1456;

/**
 * https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public int maxVowels(String s, int k) {
        return solve1(s, k);
    }

    private int solve1(String s, int k) {

        // 处理第一次
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if ("aeiou".contains(String.valueOf(chars[i]))) {
                count++;
            }
        }

        int ans = 0;
        ans = Math.max(ans, count);

        for (int left = 0, right = left + k; right < s.length(); ) {
            if ("aeiou".contains(String.valueOf(chars[left++]))) {
                count--;
            }
            if ("aeiou".contains(String.valueOf(chars[right++]))) {
                count++;
            }

            ans = Math.max(ans, count);
        }

        return ans;
    }

    public static void main(String[] args) {
        // ibpbhixfiouhdljnjfflpapptrxgcomvnb
        // ibpbhixfiouhdljnjfflpapptrxgcomvn    33-26 =
        // bpbhixfiouhdljnjfflpapptrxgcomvnb
        System.out.println(new Solution().maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33));
        // abciiidef
        // abc  1
        // bci  1
        // cii  2
        // iii  3
        // iid  2
        // ide  2
        // def  2
        System.out.println(new Solution().maxVowels("abciiidef", 3));
        System.out.println(new Solution().maxVowels("aeiou", 2));
        System.out.println(new Solution().maxVowels("leetcode", 3));
        System.out.println(new Solution().maxVowels("rhythms", 4));
    }
}