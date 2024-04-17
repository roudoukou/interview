package icu.xiamu.shuzimali;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/15
 */
public class Demo1 {
    private static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            process(m, 1, n);
        }
    }

    private static void process(int sum, int start, int end) {
        if (sum < 0 || sum > end + 1) {
            return;
        } else if (sum == 0) {
            list.stream().sorted().forEach(r -> System.out.print(r + " "));
            System.out.println();
            return;
        }
        if (sum >= start) {
            list.push(start);
            process(sum - start, start + 1, end);
            list.poll();
            process(sum, start + 1, end);
        }
    }
}
