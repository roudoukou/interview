package icu.xiamu.class328;

import icu.xiamu.common.ListNode;

/**
 * https://leetcode.cn/problems/odd-even-linked-list/?envType=study-plan-v2&envId=leetcode-75
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
    public ListNode oddEvenList(ListNode head) {
        return solve1(head);
    }

    private ListNode solve1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode current = head;
        ListNode oddHead = odd;
        ListNode evenHead = even;

        int flag = 1;
        while (current != null) {
            if ((flag & 1) != 0) {
                odd.next = new ListNode(current.val);
                odd = odd.next;
            }  else {
                even.next = new ListNode(current.val);
                even = even.next;
            }
            flag++;
            current = current.next;
        }

        odd.next = evenHead.next;

        return oddHead.next;
    }

    public static void main(String[] args) {
        ListNode.printListNode(new Solution().oddEvenList(ListNode.arrayToLinkedList(new int[]{1, 2, 3, 4, 5})));
        ListNode.printListNode(new Solution().oddEvenList(ListNode.arrayToLinkedList(new int[]{2, 1, 3, 5, 6, 4, 7})));
    }
}