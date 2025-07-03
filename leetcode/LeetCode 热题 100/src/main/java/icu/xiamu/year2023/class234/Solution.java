package icu.xiamu.year2023.class234;

import icu.xiamu.year2023.common.ListNode;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/submissions/501101977/?envType=study-plan-v2&envId=top-100-liked
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
    public boolean isPalindrome(ListNode head) {
        return solve1(head);
    }

    private boolean solve1(ListNode head1) {

        ListNode head3 = copyList(head1);
        // ListNode.printListNode(head3);

        ListNode head2 = process(head1);
        // ListNode.printListNode(head2);

        while (head3 != null) {
            if (head3.val != head2.val) {
                return false;
            }
            head3 = head3.next;
            head2 = head2.next;
        }
        return true;
    }

    /**
     * 拷贝一份ListNode
     * @param head
     * @return
     */
    private ListNode copyList(ListNode head) {
        ListNode current = new ListNode(0);
        ListNode newHead = current;
        while (head != null) {
            current.next = new ListNode(head.val);
            current = current.next;
            head = head.next;
        }
        return newHead.next;
    }

    private ListNode process(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = process(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(ListNode.arrayToLinkedList(new int[]{1, 2})));
        System.out.println(new Solution().isPalindrome(ListNode.arrayToLinkedList(new int[]{1, 1, 2, 1})));
        System.out.println(new Solution().isPalindrome(ListNode.arrayToLinkedList(new int[]{1, 2, 2, 1})));
        System.out.println(new Solution().isPalindrome(ListNode.arrayToLinkedList(new int[]{1, 2})));
    }
}