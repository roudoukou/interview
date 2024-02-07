package icu.xiamu.class1143;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return 0;
    }
}

/* 

abcdefg
achskvcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnmcnme
ace
采用直接暴力算法, 最长的时间复杂度是1000 * 1000, O(n^2)
一百万遍历, 算个鸡脖出

    a       b       c       d       e
a   a       a       a       a       a
c   a       a       ac      ac      ac
e   a       a       ac      ac      ace

有点感觉了, 但是他妈的写不出
 */