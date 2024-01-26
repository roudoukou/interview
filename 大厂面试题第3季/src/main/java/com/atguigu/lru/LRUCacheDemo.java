package com.atguigu.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheDemo<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    private static final float loadFactor = 0.75F;

    private static final boolean accessOrder = false;

    /**
     * accessOrder – the ordering mode - true for access-order, false for insertion-order
     * @param capacity
     */
    public LRUCacheDemo(int capacity) {
        super(capacity, loadFactor, accessOrder);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);

        lruCacheDemo.put(1, "a");
        lruCacheDemo.put(2, "b");
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(4, "d");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(5, "x");
        System.out.println(lruCacheDemo.keySet());

        /*
        // accessOrder = true 基于访问顺序
        // 运行结果:
        [1, 2, 3]
        [2, 3, 4]
        [2, 4, 3]
        [2, 4, 3]
        [2, 4, 3]
        [4, 3, 5]

        // accessOrder = false 基于插入顺序
        // 运行结果:
        [1, 2, 3]
        [2, 3, 4]
        [2, 3, 4]
        [2, 3, 4]
        [2, 3, 4]
        [3, 4, 5]
         */
    }
}
