package icu.xiamu.code7;

class Solution {
    public int trap(int[] height) {
        // return process1(height);
        return process2(height);
    }

    /**
     * 双指针的优化
     *
     * @param height 高度
     * @return 结果
     */
    private int process2(int[] height) {

        // if (height == null || height.length < 3) {
        //     return 0;
        // }
        //
        // int result = 0;
        // int left = 0;
        // int right = height.length - 1;
        // int maxLeft = 0;
        // int maxRight = 0;
        //
        // while (left < right) {
        //     if (height[left] < height[right]) {
        //         if (height[left] > maxLeft) {
        //             maxLeft = height[left];
        //         } else {
        //             result += (maxLeft - height[left]);
        //         }
        //         left++;
        //     }
        //     if (height[])
        // }
        //
        // return result;
        return 0;
    }

    /**
     * 暴力遍历，超时
     *
     * @param height 高度
     * @return 结果
     */
    private static int process1(int[] height) {
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = i - 1;
            int right = i + 1;

            int maxLeftHeight = height[i];
            int maxRightHeight = height[i];
            while (left >= 0) {
                if (maxLeftHeight < height[left]) {
                    maxLeftHeight = height[left];
                }
                left--;
            }
            while (right <= height.length - 1) {
                if (maxRightHeight < height[right]) {
                    maxRightHeight = height[right];
                }
                right++;
            }

            int minHeight = Math.min(maxLeftHeight, maxRightHeight);
            if (minHeight > 0) {
                result += (minHeight - height[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new Solution().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}


/*


class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0; // 不足3個柱子無法積水
        }

        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        // 計算每個位置左邊的最大高度
        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        // 計算每個位置右邊的最大高度
        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        int totalWater = 0;
        // 計算總積水
        for (int i = 0; i < n; i++) {
            // 當前位置能積水的量 = min(左邊最高, 右邊最高) - 當前柱子的高度
            // 注意：如果 minHeight <= height[i]，則積水為 0 或負數，但 Math.max(0, ...) 可以保證積水不為負
            totalWater += Math.max(0, Math.min(maxLeft[i], maxRight[i]) - height[i]);
        }

        return totalWater;
    }

}













class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0; // 記錄 left 指針移動過程中，其左側遇到的最大高度
        int maxRight = 0; // 記錄 right 指針移動過程中，其右側遇到的最大高度
        int totalWater = 0;

        while (left < right) {
            // 總是處理較矮的那一邊
            if (height[left] < height[right]) {
                // 左邊柱子較矮，更新 maxLeft
                if (height[left] >= maxLeft) {
                    maxLeft = height[left]; // 當前柱子更高，更新左邊牆壁高度
                } else {
                    // 當前柱子比 maxLeft 低，可以積水
                    totalWater += (maxLeft - height[left]);
                }
                left++; // 左指針右移
            } else {
                // 右邊柱子較矮或相等，更新 maxRight
                if (height[right] >= maxRight) {
                    maxRight = height[right]; // 當前柱子更高，更新右邊牆壁高度
                } else {
                    // 當前柱子比 maxRight 低，可以積水
                    totalWater += (maxRight - height[right]);
                }
                right--; // 右指針左移
            }
        }
        return totalWater;
    }


}
 */