package hashmap;

import java.util.Scanner;

/**
 * 第一题
 */
public class StarCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // 吃掉换行符

        int[][] sky = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                sky[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(countStars(sky));
    }

    private static int countStars(int[][] sky) {
        if (sky == null || sky.length < 3 || sky[0].length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < sky.length - 2; i++) {
            for (int j = 0; j < sky[i].length - 2; j++) {
                if (isStar(sky, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isStar(int[][] sky, int x, int y) {
        return sky[x][y] == 0 && sky[x][y + 1] == 1 && sky[x][y + 2] == 0 &&
               sky[x + 1][y] == 1 && sky[x + 1][y + 1] == 1 && sky[x + 1][y + 2] == 1 &&
               sky[x + 2][y] == 1 && sky[x + 2][y + 1] == 0 && sky[x + 2][y + 2] == 1;
    }
}
