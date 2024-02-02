package icu.xiamu.class993;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/number-of-recent-calls/submissions/500042239/?envType=study-plan-v2&envId=leetcode-75
 */
class RecentCounter {

    Queue<Integer> queue;
    public RecentCounter() {
        queue = new ArrayDeque<>();
    }
    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t-3000) {
            queue.poll();
        }

        return queue.size();
    }

/*
    // 采用数组 充当技术器
    public static int index;
    public static int[] requests = new int[10100];

    public RecentCounter() {
        Arrays.fill(requests, -1);
        index = 0;
    }

    public int ping(int t) {
        requests[index++] = t;

        int count = 0;
        for (int i = index-1; i >= 0; i--) {
            if (requests[i] != -1 && requests[i] <= t && requests[i] >= t-3000) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
*/

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */