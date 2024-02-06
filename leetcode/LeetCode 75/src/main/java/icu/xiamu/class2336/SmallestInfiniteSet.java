package icu.xiamu.class2336;


import java.util.*;

/**
 * https://leetcode.cn/problems/smallest-number-in-infinite-set/submissions/501021545/?envType=study-plan-v2&envId=leetcode-75
 */
class SmallestInfiniteSet {

    PriorityQueue<Integer> queue;

    public SmallestInfiniteSet() {
        queue = new PriorityQueue<>();
        for (int i = 1; i <= 1000; i++) {
            queue.add(i);
        }
    }

    public int popSmallest() {
        return queue.isEmpty() ? 0 : queue.poll();
    }

    public void addBack(int num) {
        if (!queue.contains(num)) {
            queue.add(num);
        }
    }

/*
    // 使用list暴力一下, 顺带排个序
    List<Integer> list = new ArrayList<>();
    public SmallestInfiniteSet() {

        for (int i = 1; i <= 1000; i++) {
            list.add(i);
        }
    }
    
    public int popSmallest() {
        Collections.sort(list);
        return list.remove(0);
    }
    
    public void addBack(int num) {
        if (!list.contains(num)) {
            list.add(num);
        }
    }
*/

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);    // 2 已经在集合中，所以不做任何变更。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 1 ，因为 1 是最小的整数，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 2 ，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 3 ，并将其从集合中移除。
        smallestInfiniteSet.addBack(1);    // 将 1 添加到该集合中。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 1 ，因为 1 在上一步中被添加到集合中，
        // 且 1 是最小的整数，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 4 ，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 5 ，并将其从集合中移除。
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */