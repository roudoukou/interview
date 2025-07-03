package icu.xiamu.year2023.class22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 不会写...
 * https://leetcode.cn/problems/generate-parentheses/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        process1(2 * n, 0);
        return result;
    }

    private void process1(int n, int index) {
        if (path.length() == n / 2) {
            result.add(path.toString());
            System.out.println(path.toString());
            return;
        }

        for (int i = index; i < n-1; i++) {
            path.append(i + 1);
            process1(n, i + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
        System.out.println(new Solution().generateParenthesis(1));
    }
}
/*
输出：["((()))","(()())","(())()","()(())","()()()"]
1 2 3 4 5 6
1 2 3
1 2 4
1 2 5
1 3 5
剔除掉最后一个的位置，最后一个肯定是没有办法成功的
 */