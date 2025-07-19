package icu.xiamu.code19;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * <a href="https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int currentRow = 0, currentColumn = 0;
        int right = matrix[0].length - 1;
        int left = 0;
        int top = 0;
        int bottom = matrix.length - 1;

        int total = (right + 1) * (bottom + 1);
        int count = 0;
        while (count < total) {
            while (left <= currentColumn && currentColumn <= right) {
                result.add(matrix[currentRow][currentColumn]);
                currentColumn++;
                count++;
            }
            top++;
            currentColumn--;
            currentRow++;
            if (count >= total) break;
            while (top <= currentRow && currentRow <= bottom) {
                result.add(matrix[currentRow][currentColumn]);
                currentRow++;
                count++;
            }
            currentRow--;
            currentColumn--;
            right--;
            if (count >= total) break;
            while (right >= currentColumn && currentColumn >= left) {
                result.add(matrix[currentRow][currentColumn]);
                currentColumn--;
                count++;
            }
            bottom--;
            currentColumn++;
            currentRow--;
            if (count >= total) break;
            while (bottom >= currentRow && currentRow >= top) {
                result.add(matrix[currentRow][currentColumn]);
                currentRow--;
                count++;
            }
            currentRow++;
            currentColumn++;
            left++;
            if (count >= total) break;
        }

        return result;
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));

    }
}