package icu.xiamu.lcr.class122;

/**
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/description/
 */
class Solution {
    public String pathEncryption(String path) {
        return solve1(path);
    }

    private String solve1(String path) {
        return path.replace(".", " ");
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pathEncryption("a.aef.qerf.bb"));
    }
}