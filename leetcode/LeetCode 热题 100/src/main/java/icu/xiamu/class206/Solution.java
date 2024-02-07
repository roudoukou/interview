package icu.xiamu.class206;

import icu.xiamu.common.ListNode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked
 * <p>
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
    public ListNode reverseList(ListNode head) {
        return solve3(head);
    }

    /**
     * 2024-2-7 14:34:10
     *
     * @param head
     * @return
     */
    private ListNode solve3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = solve3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode solve2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        newHead.next = solve2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead.next;
    }

    private ListNode solve1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(new ListNode(head.val));
            head = head.next;
        }

        ListNode sentinel = new ListNode(-1);
        head = sentinel;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop(); // peek 不删除当前节点 pop删除当前节点
            sentinel.next = node;
            sentinel = sentinel.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode.printListNode(new Solution().reverseList(ListNode.arrayToLinkedList(new int[]{1, 2, 3, 4, 5})));
    }
}