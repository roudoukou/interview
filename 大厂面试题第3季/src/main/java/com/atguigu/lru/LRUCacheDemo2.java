package com.atguigu.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDemo2 {

    // map负责查找, 构建一个虚拟的双向链表, 它里面安装的就是一个个Node节点, 作为数据载体.

    // 1.构造一个Node节点, 作为数据载体
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;


        public Node() {
            this.prev = null;
            this.next = null;
        }

        public Node(K key, V value) {
            super();
            this.key = key;
            this.value = value;
        }
    }
    // 2.构建一个虚拟的双向链表, 里面安放的就是我们的Node
    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        // 2.1 构造方法
        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        // 2.2 添加到头
        public void addHead(Node<K, V> node) {

            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        // 2.3 删除节点
        public void removeNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = null;
            node.prev = null;
        }

        // 2.4 获得最后一个节点
        public Node getLast() {
            return tail.prev;
        }
    }

    private int cacheSize;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCacheDemo2(int cacheSize) {
        this.cacheSize = cacheSize; // 坑位
        map = new HashMap<>(); // 查找
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            if (map.size() == cacheSize) {
                Node<Integer, Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }

            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key, newNode);
            doubleLinkedList.addHead(newNode);
        }
    }


    public static void main(String[] args) {
        LRUCacheDemo2 lruCacheDemo2 = new LRUCacheDemo2(3);

        lruCacheDemo2.put(1, 1);
        lruCacheDemo2.put(2, 2);
        lruCacheDemo2.put(3, 3);
        System.out.println(lruCacheDemo2.map.keySet());

        lruCacheDemo2.put(4, 4);
        System.out.println(lruCacheDemo2.map.keySet());

        lruCacheDemo2.put(3, 3);
        System.out.println(lruCacheDemo2.map.keySet());
        lruCacheDemo2.put(3, 3);
        System.out.println(lruCacheDemo2.map.keySet());
        lruCacheDemo2.put(3, 3);
        System.out.println(lruCacheDemo2.map.keySet());
        lruCacheDemo2.put(5, 100);
        System.out.println(lruCacheDemo2.map.keySet());

        /*
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
