package icu.xiamu.shuzimali1;

import java.util.Scanner;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/22
 *
 * https://blog.csdn.net/qq_41115379/article/details/121222768
 *
 * https://blog.csdn.net/weixin_53939785/article/details/122189738
 *
 * https://blog.csdn.net/qq_58210976/article/details/128633191
 */
public class Demo1 {
    public static long sum = 0;
    public final static long i = 0;
    public static int flag = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        long num = in.nextLong();
        long temp = num;
        while (temp > 0) {
            sum += (temp % 10);
            temp /= 10;
        }
        dfs(num, i);

        if (flag == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void dfs(long num, long temp) {
        if (num == 0 || temp * 2 >= sum) {
            if (temp * 2 == sum) {
                flag = 1;
                return;
            }
            return;
        }
        dfs(num / 10, temp);
        dfs(num / 10, temp + (num % 10));
    }
}
