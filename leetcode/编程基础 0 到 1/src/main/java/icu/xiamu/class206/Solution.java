package icu.xiamu.class206;

import icu.xiamu.common.ListNode;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return solve1(head);
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
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode result1 = new Solution().reverseList(node1);
        ListNode.printListNode(result1);

    }
}