package icu.xiamu.year2023.class138;

/**
 * 138. 随机链表的复制
 * https://leetcode.cn/problems/copy-list-with-random-pointer/?envType=study-plan-v2&envId=top-100-liked
 */
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        return process(head);
    }

    private Node process(Node head) {
        Node current = new Node(-1);
        Node newHead = current;

        while (head != null) {

            Node node = new Node(head.val);
            node.random = head.random;
            node.next = head.next;

            head = head.next;
            current = node;
            current = current.next;
        }

        return newHead;
    }
}