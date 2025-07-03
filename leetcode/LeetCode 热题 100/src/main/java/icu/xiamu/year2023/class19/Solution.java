package icu.xiamu.year2023.class19;

import icu.xiamu.year2023.common.ListNode;

/**
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/submissions/501169561/?envType=study-plan-v2&envId=top-100-liked
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return solve1(head, n);
    }

    private ListNode solve1(ListNode head, int n) {

        int size = getSize(head);
        // 特殊值处理
        if (size == 1) return null;
        if (size == n) return head.next;

        size -= n;

        ListNode current = head;
        ListNode lastNode = current;
        while (size-- != 0) {
            lastNode = current;
            current = current.next;
        }
        lastNode.next = lastNode.next.next;
        // current.next = current.next.next;

        return head;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static void main(String[] args) {
        ListNode.printListNode(new Solution().removeNthFromEnd(ListNode.arrayToLinkedList(new int[]{1, 2, 3, 4, 5}), 2));
        ListNode.printListNode(new Solution().removeNthFromEnd(ListNode.arrayToLinkedList(new int[]{1}), 1));
        ListNode.printListNode(new Solution().removeNthFromEnd(ListNode.arrayToLinkedList(new int[]{1, 2}), 1));
        ListNode.printListNode(new Solution().removeNthFromEnd(ListNode.arrayToLinkedList(new int[]{1, 2}), 2));
    }
}