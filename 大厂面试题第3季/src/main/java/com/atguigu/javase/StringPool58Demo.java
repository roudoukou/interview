package com.atguigu.javase;

public class StringPool58Demo {
    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        System.out.println();

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());

        //demo1();
    }

    private static void demo1() {
        String s1 = new String("11"); // 创建了String对象, 和 常量"11" 两个对象
        String s2 = s1.intern();
        String s3 = "11";

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);

        String s4 = String.valueOf(22); // 只构造了一个String对象
        String s5 = s4.intern();
        String s6 = "22";
        System.out.println(s4 == s5);
        System.out.println(s4 == s6);
    }
}
