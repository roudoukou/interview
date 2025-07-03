package icu.xiamu.year2023.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/6
 */
public class Demo4 {

    //小美拿到了一个长度为7的字符串。她想知道将该字符串修改为"meituan"至少需要修改多少次？
    // 每次修改，小美可以修改任意一个字符。
    //
    // 输入描述
    // 一个长度为7的、仅由小写字母组成的字符串。
    //
    // 输出描述
    // 小美最少的修改次数。
    //
    // 示例 1
    // 收起
    //
    // 输入
    // 复制
    // meituan
    // 输出
    // 复制
    // 0
    // 示例 2
    // 收起
    //
    // 输入
    // 复制
    // meimein
    // 输出
    // 复制
    // 3

    // 小美拿到了一个由复数组成的数组，她想知道其中有多少个实数？
    // 实数：有理数和无理数的总称。其中无理数是无限不循环小数，有理数包括整数和分数。
    //
    // 输入描述
    // 第一行输入一个正整数，代表数组的大小。
    // 第二行输入n个复数，代表小美拿到的数组。
    // 1\leq n \leq 10^5
    // 后台数据保证复数为a或者a+bi的形式，其中a和b为绝对值不超过10^9的整数。
    //
    // 输出描述
    // 一个整数，代表实数的数量。
    //
    // 示例 1
    // 收起
    //
    // 输入
    // 复制
    // 4
    // -5 5-i 6+3i -4+0i
    // 输出
    // 复制
    // 2
    // 说明
    // 第一个和第四个复数是实数。


    // 小美有一个由 n 个互不相等的正整数构成的数组 a，但她一不小心把 a 弄丢了，他想要重新找到 a。
    //
    // 好在她并不是一无所有，她还记得以下有关 a 的信息：
    //
    // 1. 他完全记得数组 b 的样子，并且 b 是数组 a 删除了某个 a_i 后，剩余的部分做前缀和并打乱的结果。
    // 2. 他完全记得数组 c 的样子，并且 c 是数组 a 删除了某个 a_j 后，剩余的部分做前缀和并打乱的结果。
    // （保证两次删除的 a_i 和 a_j 不是同一个 a 中的元素）。
    //
    // 请你帮她还原出 a 数组吧。
    //
    // 补充：前缀和指一个数组的某下标之前的所有数组元素的和（包含其自身）。
    // 输入
    // 4
    // 8 18 14
    // 15 9 1
    // 输出
    // 1 8 6 4
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int arrSize = scanner.nextInt();
            long[] b = new long[arrSize-1];
            long[] c = new long[arrSize-1];
            for (int i = 0; i < arrSize-1; i++) {
                b[i] = scanner.nextLong();
            }
            for (int i = 0; i < arrSize-1; i++) {
                c[i] = scanner.nextLong();
            }

            Arrays.sort(b);
            Arrays.sort(c);



        }
    }
}
