package icu.xiamu.meituan;

import java.util.Scanner;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/6
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String n = in.nextLine();

            String nextLine = in.nextLine();
            String[] split = nextLine.split(" ");
            int count = 0;
            for (String s : split) {
                // -5
                // 5-i
                // 6+3i
                // -4+0i
                // System.out.println(s);
                // if (s.contains("+0i")) {
                //     count++;
                // } else if (!s.contains("i")) {
                //     count++;
                // }
                if (check(s)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean check(String number) {
        number = number.trim();
        if (number.isEmpty()) {
            return false;
        }
        if (number.charAt(0) == '+' || number.charAt(0) == '-') {
            number = number.substring(1);
        }

        if (number.endsWith("0i")) {
            return true;
        }
        if (number.contains("i")) {
            return false;
        }
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
