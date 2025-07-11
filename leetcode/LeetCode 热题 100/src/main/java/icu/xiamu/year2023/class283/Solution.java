package icu.xiamu.year2023.class283;

/**
 * https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=top-100-liked
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        solve4(nums);

        for (int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    private void solve4(int[] nums) {
        int[] ans = new int[nums.length];
        int zero = 0;
        for (int num : nums) {
            if (num == 0) {
                zero++;
            }
        }

        // Arrays.sort(nums);
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                ans[index++] = num;
            }
        }

        // nums = Arrays.stream(ans).toArray();
        index = 0;
        for (int an : ans) {
            nums[index++] = an;
        }
    }


    private void solve3(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int right = 0;
        int left = 0;

        int zero = 0; // 记录 0 的个数
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                zero++;
                left++;
            }
            right++;
        }

        while (left < nums.length) {
            nums[left++] = 0;
        }
    }

    /**
     * 0, 1, 0, 3, 12
     * 1  1  0  3  12
     * 1  3  0  3  12
     * 1  3  12 3  12
     * 1  3  12 0  0
     *
     * @param nums
     */
    private void solve2(int[] nums) {
        int i = 0, j = 0, zeroCount = 0;
        while (i != nums.length) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }

            i++;
        }
        while (j != nums.length) {
            nums[j] = 0;
            j++;
        }
    }

    private static void solve1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }

        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[index++] = nums[i];
            }
        }

        System.arraycopy(result, 0, nums, 0, nums.length);
    }


    public static void main(String[] args) {
        new Solution().moveZeroes(new int[]{2, 1});
        new Solution().moveZeroes(new int[]{0, 1, 0, 3, 12});
        new Solution().moveZeroes(new int[]{0});
    }
}
