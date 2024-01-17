package icu.xiamu;

public class BM17 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * -1, 0, 3, 4, 6, 10, 13, 14
     * 6
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        return find1(nums, 0, nums.length, target);
    }

    /**
     * 二分法模板
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    private int find1(int[] nums, int left, int right, int target) {
        if (nums.length <= 0 || left >= right) {
            return -1;
        }

        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return find1(nums, left, middle, target);
        } else {
            return find1(nums, middle+1, right, target);
        }
    }

    public static void main(String[] args) {
        // int[] nums = {-1, 0, 3, 4, 6, 10, 13, 14};
        // int target = 11;
        int[] nums = {-1, 1};
        int target = -1;
        int result = new BM17().search(nums, target);
        System.out.println("result = " + result);
    }
}
