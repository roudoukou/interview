package icu.xiamu.class1822;

class Solution {
    public int arraySign(int[] nums) {
        return solve(nums);
    }

    private int solve(int[] nums) {
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            }
            if (nums[i] > 0) {
                result *= 1;
            } else {
                result *= -1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
        // System.out.println(new Solution().arraySign(new int[]{1, 5, 0, 2, -3}));
        // System.out.println(new Solution().arraySign(new int[]{-1, 1, -1, 1, -1}));
        // System.out.println(new Solution().arraySign(new int[]{56,32,76,92,78,91,-100,-82,-40,-63,-48,-55,-59,-81,-35,-59,-29}));
        System.out.println(new Solution().arraySign(new int[]{41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41}));
    }
}