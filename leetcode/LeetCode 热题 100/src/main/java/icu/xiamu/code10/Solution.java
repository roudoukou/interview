package icu.xiamu.code10;


import java.util.HashMap;

/**
 * 解题思路：
 * <a href="https://www.bilibili.com/video/BV1gN411E7Zx">...</a>
 * 560. 和为 K 的子数组
 * <a href="https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public int subarraySum(int[] nums, int k) {

        // return process1(nums, k);
        return process2(nums, k);
    }

    /**
     * 为什么「前缀和+ 哈希表」能解决问题？
     * 让我来用一个更直观的方式解释一下这个核心思路：
     *
     * 我们最终想找到的是有多少个子阵列nums[i...j](从索引i到j的连续子阵列) 的和等于k。
     *
     * 假设我们有一个阵列[A, B, C, D, E]。 如果我们知道：
     *
     * 从开头到C的和是sum_C(即A+B+C)
     *
     * 从开头到A(也就是i-1的位置，在A之前我们可以认为是0) 的和是sum_A_before(在阵列开头可以想像成0)
     *
     * 那么，子阵列[B, C]的和就等于sum_C - sum_A_before。
     *
     * 所以，问题sum(nums[i...j]) == k就等价于：
     * preSum[j] - preSum[i-1] == k
     *
     * 进一步变形一下，就成了：
     * preSum[i-1] == preSum[j] - k
     *
     * 这句话非常关键！它告诉我们： 当我们遍历到阵列的第j个元素，算出目前为止的前缀和preSum[j]时，我们需要回头看看之前有没有一个前缀和，它的值恰好是preSum[j] - k。 如果找到了，那就意味着从那个之前的前缀和的位置的下一个元素开始，直到目前的j位置，这个子阵列的和正好是k！
     *
     * 而哈希表的作用，就是快速地帮我们「回头看」，去查阅之前出现过哪些前缀和，以及它们各自出现了多少次。
     *
     * @param nums 数组
     * @param k    整数数组
     * @return 结果
     */
    private int process2(int[] nums, int k) {

        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int preSum = 0;
        for (int num : nums) {

            preSum += num;

            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }

            map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        }

        return count;
    }

    /**
     * 超时
     *
     * @param nums 数组
     * @param k    整数数组
     * @return 结果
     */
    private int process1(int[] nums, int k) {
        int length = nums.length;
        int count = 0;

        int left = 0;
        int right = 0;

        while (left < length) {
            int sum = sum(nums, left, right);
            if (sum < k) {
                right++;
            } else if (sum == k) {
                count++;
                right++;
                // left = right;
                // right++;
            } else {
                right++;
            }

            if (right >= length) {
                left++;
                right = left;
            }
        }


        return count;
    }

    public int sum(int[] nums, int left, int right) {

        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(new Solution().subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(new Solution().subarraySum(new int[]{1}, 0));
        System.out.println(new Solution().subarraySum(new int[]{-1, -1, 1}, 0));
        System.out.println(new Solution().subarraySum(new int[]{1, -1, 0}, 0));
    }
}