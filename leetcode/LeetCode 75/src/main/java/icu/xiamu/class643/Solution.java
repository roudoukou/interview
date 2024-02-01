package icu.xiamu.class643;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        return solve2(nums, k);
    }

    /**
     * 使用滑动窗口, 寻找最大窗口, 最后再计算平均值
     * @param nums
     * @param k
     * @return
     */
    private double solve2(int[] nums, int k) {

        // 提前算出第一个区间的值
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans, sum);

        // 滑动窗口找到最大的区间
        int left = 0;
        int right = left + k;
        while (right < nums.length) {
            sum = sum - nums[left++] + nums[right++];
            ans = Math.max(ans, sum);
        }

        return ans * 1.0 / k;
    }


    /**
     * 算出第一个值, 然后减去前一个, 加上后一个, 遍历一遍, 找到最大值返回
     * @param nums
     * @param k
     * @return
     */
    private double solve1(int[] nums, int k) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = left + k - 1;

        // 算出初始值
        double avg = Integer.MIN_VALUE;

        double sum = 0;
        double ans = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        ans = Math.max(ans, sum / k);
        avg = sum / k;
        right++;

        while (right < nums.length) {
            // avg = Math.max(avg, (avg * k + nums[right++] - nums[left++]) / k);
            // if (right + 1 > nums.length) {
            //     sum = avg * k + nums[right] - nums[left];
            //     avg = Math.max(avg, sum / k);
            // } else {
                sum = avg * k + nums[right++] - nums[left++];
                ans = Math.max(ans, sum / k);
                avg = sum / k;
            // }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1)); // 4.0
        System.out.println(new Solution().findMaxAverage(new int[]{0, 1, 1, 3, 3}, 4)); // 2.0
        System.out.println(new Solution().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); // 12.75
        System.out.println(new Solution().findMaxAverage(new int[]{5}, 1)); // 5
        System.out.println(new Solution().findMaxAverage(new int[]{8860, -853, 6534, 4477, -4589, 8646, -6155, -5577, -1656, -5779, -2619, -8604, -1358, -8009, 4983, 7063, 3104, -1560, 4080, 2763, 5616, -2375, 2848, 1394, -7173, -5225, -8244, -809, 8025, -4072, -4391, -9579, 1407, 6700, 2421, -6685, 5481, -1732, -8892, -6645, 3077, 3287, -4149, 8701, -4393, -9070, -1777, 2237, -3253, -506, -4931, -7366, -8132, 5406, -6300, -275, -1908, 67, 3569, 1433, -7262, -437, 8303, 4498, -379, 3054, -6285, 4203, 6908, 4433, 3077, 2288, 9733, -8067, 3007, 9725, 9669, 1362, -2561, -4225, 5442, -9006, -429, 160, -9234, -4444, 3586, -5711, -9506, -79, -4418, -4348, -5891}, 93));
    }
}