package icu.xiamu.other;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author 肉豆蔻吖
 * @date 2024/3/18
 */
public class Test1 {
    public static void main(String[] args) throws IOException {


        // 写一个冒泡排序程序
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
