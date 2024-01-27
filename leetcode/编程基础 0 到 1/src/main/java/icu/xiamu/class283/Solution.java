package icu.xiamu.class283;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void moveZeroes(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                list.add(i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            
        }
    }

    public static void main(String[] args) {
        new Solution().moveZeroes(new int[]{0, 1, 0, 3, 12});
        new Solution().moveZeroes(new int[]{0});
    }
}