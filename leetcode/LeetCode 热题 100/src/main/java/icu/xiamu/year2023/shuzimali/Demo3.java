package icu.xiamu.year2023.shuzimali;

import java.util.*;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/15
 */
public class Demo3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int x = in.nextInt();
            System.out.println(process(a, b, c, x));
        }
    }

    // 现给出正整数a, b, c,并给出一个正整数x, 请你判断x的大小与a, b, c哪一个数更接近
    private static String process(int a, int b, int c, int x) {
        int x1 = Math.abs(x - a);
        int x2 = Math.abs(x - b);
        int x3 = Math.abs(x - c);
        if (x1 == x2 || x2 == x3 || x1 == x3) {
            return "same";
        }


        if (x1 < x2 && x1 < x3) {
            return "A";
        } else if (x2 < x1 && x2 < x3) {
            return "B";
        } else {
            return "C";
        }
        // return demo(a, b, c, x);
    }

    private static String demo(int a, int b, int c, int x) {
        int x1 = Math.abs(x - a);
        int x2 = Math.abs(x - b);
        int x3 = Math.abs(x - c);
        if (x1 == x2 || x2 == x3 || x1 == x3) {
            return "same";
        }

        // 现给出正整数a, b, c,并给出一个正整数x, 请你判断x的大小与a, b, c哪一个数更接近
        // 123 132 231 213 321 312
        int min = Math.min(x1, Math.min(x2, x3));
        if (min == x1) {
            return "A";
        } else if (min == x2) {
            return "B";
        } else {
            return "C";
        }
    }
}

/*
1 2 3
5
C
 */
