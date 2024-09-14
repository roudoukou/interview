package main.java.class461;

import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int hammingDistance(int x, int y) {
        if (x == y) {
            return 0;
        }

        String x1 = Integer.toString(x, 2);
        String y1 = Integer.toString(y, 2);
        int diff = Math.abs(x1.length() - y1.length());
        if (x1.length() > y1.length()) {
            y1 = Stream.generate(() -> "0").limit(diff).collect(Collectors.joining()) + y1;
        } else if (x1.length() < y1.length()) {
            x1 = Stream.generate(() -> "0").limit(diff).collect(Collectors.joining()) + x1;
        }
        int length = x1.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (((int) x1.charAt(i) ^ (int) y1.charAt(i)) == 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1, 4));
        System.out.println(new Solution().hammingDistance(3, 1));
    }
}