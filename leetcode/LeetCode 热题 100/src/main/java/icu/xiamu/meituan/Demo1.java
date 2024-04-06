package icu.xiamu.meituan;

import java.util.Scanner;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/6
 */
public class Demo1 {
    public static void main(String[] args) {
        String result = "meituan";
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String input = in.nextLine();
            int count = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) != result.charAt(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
