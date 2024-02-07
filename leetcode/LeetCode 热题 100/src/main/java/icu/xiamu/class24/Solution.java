package icu.xiamu.class24;

import icu.xiamu.common.ListNode;

/**
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked
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
    public ListNode swapPairs(ListNode head) {
        // 不会写qwq
        return solve1(head);
    }

    private ListNode solve1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode result = head.next;

        ListNode first = head;
        ListNode second = head.next;
        ListNode temp = null;

        while (second != null && second.next != null) {

            temp = second.next.next;
            second.next = first;
            first.next = temp;

            if (first.next != null && first.next.next != null) {
                first = first.next;
                second = first.next;
            } else {
                break;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        ListNode.printListNode(new Solution().swapPairs(ListNode.arrayToLinkedList(new int[]{1, 2, 3, 4})));
        ListNode.printListNode(new Solution().swapPairs(ListNode.arrayToLinkedList(new int[]{})));
        ListNode.printListNode(new Solution().swapPairs(ListNode.arrayToLinkedList(new int[]{1})));
    }
}