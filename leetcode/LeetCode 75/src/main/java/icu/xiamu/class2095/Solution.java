package icu.xiamu.class2095;

import icu.xiamu.common.ListNode;

/**
 * https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        return solve2(head);
    }

    /**
     * 使用快慢指针解决
     * @param head 头指针
     * @return head
     */
    private ListNode solve2(ListNode head) {

        if (head.next == null) {return null;}

        ListNode virHead = new ListNode(0, head); // 添加一个多余的头节点
        ListNode slow = virHead;
        ListNode fast = virHead;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return virHead.next;
    }

    /**
     * 遍历找到长度 , 长度 / 2
     * @param head 头结点
     * @return head
     */
    private ListNode solve1(ListNode head) {
        int size = getSize(head);

        if (size <= 1) {
            return head.next;
        }

        ListNode current = head;

        int mid = size / 2;
        while (mid-- != 1) {
            current = current.next;
        }

        current.next = current.next.next;

        return head;
    }

    private int getSize(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        ListNode.printListNode(new Solution().deleteMiddle(ListNode.arrayToLinkedList(new int[]{1, 3, 4, 7, 1, 2, 6})));
        ListNode.printListNode(new Solution().deleteMiddle(ListNode.arrayToLinkedList(new int[]{1})));
        ListNode.printListNode(new Solution().deleteMiddle(ListNode.arrayToLinkedList(new int[]{1, 3, 4, 7, 1, 2, 6})));
        ListNode.printListNode(new Solution().deleteMiddle(ListNode.arrayToLinkedList(new int[]{1, 2, 3, 4})));
    }
}