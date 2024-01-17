package wyy;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            int result = process(a, b);
            System.out.println(result);

        }

        // 100000000
        // 2147483647
    }

    private static int process(int a, int b) {
        if (a <= 0 || b <= 0) {
            return 0;
        }

        int c = a / b;

        if (c * b < a) {
            c++;
        }


        return c;
    }
}
