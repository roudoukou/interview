package icu.xiamu;

public class BM65 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * longest common subsequence
     *
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String s1, String s2) {
        // write code here

        // 仅仅只是获取最长子串的长度
        // int solve1 = solve1(s1, s2, s1.length(), s2.length());
        // System.out.println(solve1);

        // 获取最长的子串, 并且逆序
        // StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.append(solve2(s1, s2, s1.length(), s2.length()));
        // String result = stringBuilder.reverse().toString();
        // if (result.equals("")) {
        //     return "-1";
        // }
        // return result;

        // String result = solve3(s1, s2, 0, 0);
        // return result.equals("") ? "-1" : result;

        String result = solve4(s1, s2);
        return result.equals("") ? "-1" : result;
    }

    // 针对于solve3的动态规划
    private String solve4(String s1, String s2) {

        // 初始化dp
        String[][] dp = new String[s1.length() + 2][s2.length() + 2];
        for (int s1Index = s1.length(); s1Index >= 0; s1Index--) {
            dp[s1Index][s2.length()] = "";
        }

        for (int s2Index = s2.length(); s2Index >= 0; s2Index--) {
            dp[s1.length()][s2Index] = "";
        }

        // 状态转移方程
        for (int s1Index = s1.length() - 1; s1Index >= 0; s1Index--) {
            for (int s2Index = s2.length() - 1; s2Index >= 0; s2Index--) {

                if (s1.charAt(s1Index) == s2.charAt(s2Index)) {
                    dp[s1Index][s2Index] = s1.charAt(s1Index) + dp[s1Index + 1][s2Index + 1];
                } else {
                    String str1 = dp[s1Index + 1][s2Index];
                    String str2 = dp[s1Index][s2Index + 1];
                    dp[s1Index][s2Index] = str1.length() > str2.length() ? str1 : str2;
                }
            }
        }

        return dp[0][0];
    }

    // 获取最长公共子串 (运行超时), 从前往后
    private String solve3(String s1, String s2, int s1Index, int s2Index) {
        if (s1Index == s1.length() || s2Index == s2.length()) {
            return "";
        }

        if (s1.charAt(s1Index) == s2.charAt(s2Index)) {
            return s1.charAt(s1Index) + solve3(s1, s2, s1Index + 1, s2Index + 1);
        } else {
            String str1 = solve3(s1, s2, s1Index + 1, s2Index);
            String str2 = solve3(s1, s2, s1Index, s2Index + 1);
            return str1.length() > str2.length() ? str1 : str2;
        }
    }


    // 获取最长公共子串 (运行超时), 从后往前
    private String solve2(String s1, String s2, int s1Index, int s2Index) {
        if (s1Index == 0 || s2Index == 0) {
            return "";
        }

        if (s1.charAt(s1Index - 1) == s2.charAt(s2Index - 1)) {
            return s1.charAt(s1Index - 1) + solve2(s1, s2, s1Index - 1, s2Index - 1);
        } else {
            String str1 = solve2(s1, s2, s1Index - 1, s2Index);
            String str2 = solve2(s1, s2, s1Index, s2Index - 1);
            return str1.length() > str2.length() ? str1 : str2;
        }

    }

    // 计算出最长公共子串的长度
    private int solve1(String s1, String s2, int s1Index, int s2Index) {
        if (s1 == null || s2 == null || s1.length() <= 0 || s2.length() <= 0 || s1Index <= 0 || s2Index <= 0) {
            return -1;
        }

        if (s1.charAt(s1Index - 1) == s2.charAt(s2Index - 1)) {
            return solve1(s1, s2, s1Index - 1, s2Index - 1) + 1;
        } else {
            int p1 = solve1(s1, s2, s1Index - 1, s2Index);
            int p2 = solve1(s1, s2, s1Index, s2Index - 1);
            return Math.max(p1, p2);
        }
    }


    public static void main(String[] args) {
        // String result = new BM65().LCS("1A2C3D4B56", "B1D23A456A");
        // String result = new BM65().LCS("abc", "def");
        // String result = new BM65().LCS("ab", "");
        // String result = new BM65().LCS("1a1a31","1a231"); // "1a31"
        String result = new BM65().LCS("1AB2345CD", "12345EF"); // "1a31"
        System.out.println(result);
    }
}
