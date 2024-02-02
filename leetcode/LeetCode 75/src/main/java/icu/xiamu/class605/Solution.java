package icu.xiamu.class605;

/**
 * https://leetcode.cn/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        return solve1(flowerbed, n);
    }

    private boolean solve1(int[] flowerbed, int n) {

        if (flowerbed.length <= 1 && n == 0) {
            return true;
        }
        if (flowerbed.length <= 1 && n == 1 && flowerbed[0] == 0) {
            return true;
        }
        if (flowerbed.length <= 1 && n == 1 && flowerbed[0] == 1) {
            return false;
        }
        if (flowerbed.length <= 1 && n > 1) {
            return false;
        }

        // 处理前面
        if (flowerbed[0] == flowerbed[1] && flowerbed[0] == 0) {
            n--;
            flowerbed[0] = 1;
        }

        // 处理中间
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i - 1] == flowerbed[i] && flowerbed[i] == flowerbed[i + 1] && flowerbed[i] == 0) {
                n--;
                flowerbed[i] = 1;
            }
        }

        // 处理后面
        if (flowerbed[flowerbed.length - 2] == flowerbed[flowerbed.length - 1] && flowerbed[flowerbed.length - 1] == 0) {
            n--;
            flowerbed[flowerbed.length - 1] = 1;
        }
        return n <= 0;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().canPlaceFlowers(new int[]{0, 0, 1, 0, 0}, 1));
        System.out.println(new Solution().canPlaceFlowers(new int[]{1}, 1));
        System.out.println(new Solution().canPlaceFlowers(new int[]{1}, 0));
        System.out.println(new Solution().canPlaceFlowers(new int[]{0}, 1));
        System.out.println(new Solution().canPlaceFlowers(new int[]{1}, 1));
        System.out.println(new Solution().canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
        System.out.println(new Solution().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1)); // true
        System.out.println(new Solution().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2)); // false
        System.out.println(new Solution().canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2)); // false
        System.out.println(new Solution().canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1)); // true
    }
}