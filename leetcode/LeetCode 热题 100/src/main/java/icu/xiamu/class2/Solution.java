package icu.xiamu.class2;

import icu.xiamu.common.ListNode;

/**
 * https://leetcode.cn/problems/add-two-numbers/submissions/501145384/?envType=study-plan-v2&envId=top-100-liked
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return solve3(l1, l2);
    }

    /**
     * 2024-2-7 17:16:33
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode solve3(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode current = head;

        int font = 0; // 表示进位
        int sum = 0;

        while (l1 != null && l2 != null) {

            sum = l1.val + l2.val + font;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (sum >= 10) {
                font = sum / 10;
            } else {
                font = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + font;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (sum >= 10) {
                font = sum / 10;
            } else {
                font = 0;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + font;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (sum >= 10) {
                font = sum / 10;
            } else {
                font = 0;
            }
            l2 = l2.next;
        }

        if (font != 0) { // 进最高位
            current.next = new ListNode(font);
            current = current.next;
        }

        return head.next;
    }

    private ListNode solve2(ListNode l1, ListNode l2) {

        ListNode current = new ListNode(0);
        ListNode head = current;

        int font = 0; // 表示是否需要进位
        while (l1 != null && l2 != null) {
            if (l1.val + l2.val + font >= 10) {
                current.next = new ListNode((l1.val + l2.val + font) % 10);
                current = current.next;

                font = (l1.val + l2.val + font) / 10;
            } else {
                current.next = new ListNode(l1.val + l2.val + font);
                current = current.next;

                font = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            if (l1.val + font >= 10) {
                current.next = new ListNode((l1.val + font) % 10);
                current = current.next;

                font = (l1.val + font) / 10;
            } else {
                current.next = new ListNode(l1.val + font);
                current = current.next;

                font = 0;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            if (l2.val + font >= 10) {
                current.next = new ListNode((l2.val + font) % 10);
                current = current.next;

                font = (l2.val + font) / 10;
            } else {
                current.next = new ListNode(l2.val + font);
                current = current.next;

                font = 0;
            }
            l2 = l2.next;
        }

        if (font != 0) {
            current.next = new ListNode(font);
            current = current.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode.printListNode(new Solution().addTwoNumbers(ListNode.arrayToLinkedList(new int[]{2, 4, 3}), ListNode.arrayToLinkedList(new int[]{5, 6, 4})));
        ListNode.printListNode(new Solution().addTwoNumbers(ListNode.arrayToLinkedList(new int[]{0}), ListNode.arrayToLinkedList(new int[]{0})));
        ListNode.printListNode(new Solution().addTwoNumbers(ListNode.arrayToLinkedList(new int[]{9, 9, 9, 9, 9, 9, 9}), ListNode.arrayToLinkedList(new int[]{9, 9, 9, 9})));
    }
}