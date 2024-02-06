package icu.xiamu.backtrace.class77;

import java.util.ArrayList;
import java.util.List;

/**
 * 77.组合 https://leetcode.cn/problems/combinations/description/
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        process(n, k, 1);
        return result;
    }

    private void process(int n, int k, int index) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // for (int i = index; i <= n; i++) {
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            process(n, k, i+1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 3));
        System.out.println(new Solution().combine(4, 2));
        System.out.println(new Solution().combine(1, 1));
    }
}