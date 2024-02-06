package icu.xiamu.class216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum-iii/solutions/47700/hui-su-jian-zhi-by-liweiwei1419/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        // 预处理特殊值
        int maxValue = 0;
        for (int i = 1; i <= k; i++) {
            maxValue += i;
            path.add(i);
        }
        if (maxValue == n) {
            result.add(path);
            return result;
        } else {
            path.clear();
            result.clear();

            process(k, n, 1);
            return result;
        }

    }

    private void process(int k, int n, int index) {
        if (path.size() == k) {
            int sum = 0;
            for (Integer p : path) {
                sum += p;
            }
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }


        // 控制变量的范围在 0-9
        for (int i = index; i <= (n > 10 ? 9 : n); i++) {
            path.add(i);
            process(k, n, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7));
        System.out.println(new Solution().combinationSum3(3, 9));
        System.out.println(new Solution().combinationSum3(4, 1));
        System.out.println(new Solution().combinationSum3(9, 45));
        System.out.println(new Solution().combinationSum3(2, 18));
    }
}