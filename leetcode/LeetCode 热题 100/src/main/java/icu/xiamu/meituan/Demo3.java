package icu.xiamu.meituan;

import java.util.*;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/6
 */
public class Demo3 {
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

            Queue<Long> queue1 = new LinkedList<>();
            Queue<Long> queue2 = new LinkedList<>();
            queue1.add(b[0]);
            for (int i = 1; i < arrSize-1; i++) {
                queue1.add(b[i] - b[i-1]);
            }
            queue2.add(c[0]);
            for (int i = 1; i < arrSize-1; i++) {
                queue2.add(c[i] - c[i-1]);
            }

            // 8 6 4
            // 1 8 6

            // 或者
            // 8 6 4
            // 8 1 6
            // 8 1 6 4

            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                if (queue1.peek() == queue2.peek()) {
                    System.out.print(queue1.peek() + " ");
                    queue1.poll();
                    queue2.poll();
                } else if (queue1.peek() < queue2.peek()) {
                    System.out.print(queue1.peek() + " ");
                    queue1.poll();
                } else {
                    System.out.print(queue2.peek() + " ");
                    queue2.poll();
                }
            }
            while (!queue1.isEmpty()) {
                System.out.print(queue1.peek() + " ");
                queue1.poll();
            }
            while (!queue2.isEmpty()) {
                System.out.print(queue2.peek() + " ");
                queue2.poll();
            }

            // HashSet<Long> result = new LinkedHashSet<>(set2);
            // result.removeAll(set1);
            // result.addAll(set1);
            // result.forEach(r -> System.out.print(r + " "));
        }
    }
}

/*
4
8 18 14
15 9 1
 */