package icu.xiamu.class2;

import icu.xiamu.common.ListNode;

/**
 * https://leetcode.cn/problems/add-two-numbers/?envType=study-plan-v2&envId=programming-skills
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
        return solve2(l1, l2);
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

    // 转成 int 类型然后相加, 此方法会产生越界
    private ListNode solve1(ListNode l1, ListNode l2) {
        int num1 = reverseListNode(l1);
        int num2 = reverseListNode(l2);
        int num3 = num1 + num2;

        if (num3 == 0) {
            return new ListNode(0);
        }

        ListNode current = new ListNode(-1);
        ListNode head = current;
        while (num3 != 0) {
            current.next = new ListNode(num3 % 10);
            current = current.next;
            num3 /= 10;
        }

        return head.next;
    }

    private int reverseListNode(ListNode head) {
        int result1 = 0;
        while (head != null) {
            result1 = result1 * 10 + head.val;
            head = head.next;
        }

        // 逆序
        int result2 = 0;
        while (result1 != 0) {
            result2 = result2 * 10 + result1 % 10;
            result1 /= 10;
        }

        return result2;
    }

    public static void main(String[] args) {
        // int[] arr1 = new int[]{2, 4, 3};
        // int[] arr2 = new int[]{5, 6, 4};
        // ListNode l1 = ListNode.arrayToLinkedList(arr1);
        // ListNode l2 = ListNode.arrayToLinkedList(arr2);
        // ListNode.printListNode(new Solution().addTwoNumbers(l1, l2));
        //
        // int[] arr3 = new int[]{0};
        // int[] arr4 = new int[]{0};
        // ListNode l3 = ListNode.arrayToLinkedList(arr3);
        // ListNode l4 = ListNode.arrayToLinkedList(arr4);
        // ListNode.printListNode(new Solution().addTwoNumbers(l3, l4));

        int[] arr5 = new int[]{9, 9, 9, 9, 9, 9, 9};
        int[] arr6 = new int[]{9, 9, 9, 9};
        ListNode l5 = ListNode.arrayToLinkedList(arr5);
        ListNode l6 = ListNode.arrayToLinkedList(arr6);
        ListNode.printListNode(new Solution().addTwoNumbers(l5, l6));

        // ListNode l7 = ListNode.arrayToLinkedList(new int[]{9});
        // ListNode l8 = ListNode.arrayToLinkedList(new int[]{1, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        // ListNode.printListNode(new Solution().addTwoNumbers(l7, l8));
    }
}