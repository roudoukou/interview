package icu.xiamu.class790;

class Solution {
    public int numTilings(int n) {
        return solve1(n);
    }
    private static final long MOD = (long) 1e9 + 7; // 为啥要mod俺也不晓得, 这不数据越界怪我不处理? 实际答案岂不是变小了?

    private int solve1(int n) {
        if (n <= 2) return n;
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;
        for (int i = 3; i < n; i++) {
            dp[i] = (dp[i-1]  * 2 + dp[i-3]) % MOD;
        }
        return (int) dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTilings(30));
        System.out.println(new Solution().numTilings(3));
        System.out.println(new Solution().numTilings(1));
        System.out.println(new Solution().numTilings(8)); // 258
    }
}


/*

1 2 3 4  5  6  7   8
1 2 5 11 24 53 117 258

    前一个 * 2 + 前两个



n = 1
1

n = 2
2

n = 3
5

n = 4
11

n = 5
24
 */