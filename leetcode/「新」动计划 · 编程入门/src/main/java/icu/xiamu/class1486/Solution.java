package icu.xiamu.class1486;

/**
 * https://leetcode.cn/problems/xor-operation-in-an-array/submissions/500155861/?envType=study-plan-v2&envId=primers-list
 */
class Solution {
    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= (start + 2 * i);
        }
        return ans;
    }
}