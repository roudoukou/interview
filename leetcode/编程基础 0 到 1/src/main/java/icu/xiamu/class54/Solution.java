package icu.xiamu.class54;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/spiral-matrix/submissions/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        return solve1(matrix);
    }

    private List<Integer> solve1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        int dx = 0;
        int dy = 0;
        while (left <= right && up <= down) {
            while (dy <= right && left <= right && up <= down) {
                list.add(matrix[dx][dy++]);
            }
            up++;
            dy--;
            dx++;

            while (dx <= down && left <= right && up <= down) {
                list.add(matrix[dx++][dy]);
            }
            right--;
            dx--;
            dy--;

            while (dy >= left && left <= right && up <= down) {
                list.add(matrix[dx][dy--]);
            }
            down--;
            dy++;
            dx--;

            while (dx >= up && left <= right && up <= down) {
                list.add(matrix[dx--][dy]);
            }
            left++;
            dx++;
            dy++;

        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new Solution().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}