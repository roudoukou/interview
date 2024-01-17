package icu.xiamu;

import java.util.ArrayList;

public class BM98 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix int整型二维数组
     * @return int整型ArrayList
     */
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // write code here
        return solve(matrix);
    }

    private ArrayList<Integer> solve(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length <= 0) {
            return result;
        }

        int up = 0;
        int left = 0;
        int down = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            up++;
            if (up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            down--;
            if (down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // [[1,2,3],[4,5,6],[7,8,9]]
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        ArrayList<Integer> integers = new BM98().spiralOrder(matrix);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }
}
