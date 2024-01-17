package icu.xiamu;

import java.util.Arrays;

public class BM83 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param n int整型
     * @return string字符串
     */
    public String trans(String s, int n) {
        // write code here
        String[] strings = s.split(" ");
        int length = strings.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length - 1; i > 0; i--) {
            stringBuilder.append(letter(strings[i]));
            stringBuilder.append(" ");
        }
        stringBuilder.append(letter(strings[0]));
        return stringBuilder.toString();
    }

    /**
     * 将首字母大写
     * @param letter
     * @return
     */
    public String letter(String letter) {
        char[] chars = letter.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
            } else if (Character.isUpperCase(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            } else {

            }
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        /*String this_is_a_sample = new BM83().trans("This is a sample", 16);*/
        String h_i_ = new BM83().trans("h i ", 4);
        System.out.println(h_i_);
    }
}
