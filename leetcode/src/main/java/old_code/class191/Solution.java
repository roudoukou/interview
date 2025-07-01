package class191;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Solution {
    public int hammingWeight(int n) {
        AtomicInteger count = new AtomicInteger();
        String string = Integer.toString(n, 2);
        IntStream.range(0, string.length()).forEach(i -> {
            char c = string.charAt(i);
            if (c == '1') {
                count.getAndIncrement();
            }
        });
        return count.get();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(11));
        System.out.println(new Solution().hammingWeight(128));
        System.out.println(new Solution().hammingWeight(2147483645));
    }
}