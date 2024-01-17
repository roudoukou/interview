package demo04;

import java.util.Arrays;

/**
 * 基本类型传值是值传递
 * 引用数据类型是传递地址(引用)
 * 字符串对象不可变
 *
 */
public class demo04 {
    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 2;
        int[] arr = {1, 2, 3, 4, 5};
        MyData my = new MyData();

        change(i, str, num, arr, my);
        System.out.println("i = " + i);
        System.out.println("str = " + str);
        System.out.println("num = " + num);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("my.a = " + my.a);
    }

    private static void change(int j, String s, Integer n, int[] a, MyData m) {
        j += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        m.a += 1;
    }
}

class MyData {
    int a = 10;
}