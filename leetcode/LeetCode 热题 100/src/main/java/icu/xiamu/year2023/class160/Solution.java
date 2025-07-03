package icu.xiamu.year2023.class160;

import icu.xiamu.year2023.common.ListNode;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/?envType=study-plan-v2&envId=top-100-liked
 *
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return solve1(headA, headB);
    }

    private ListNode solve1(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);

        // 谁长谁先走
        int diff = 0;
        if (sizeA > sizeB) {
            diff = sizeA - sizeB;

            while (diff-- != 0) {
                headA = headA.next;
            }

        } else {
            diff = sizeB - sizeA;
            while (diff-- != 0) {
                headB = headB.next;
            }
        }

        // 同时出发
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getSize(ListNode head) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getIntersectionNode(ListNode.arrayToLinkedList(new int[]{4, 1, 8, 4, 5}), ListNode.arrayToLinkedList(new int[]{5, 6, 1, 8, 4, 5})).val);
        System.out.println(new Solution().getIntersectionNode(ListNode.arrayToLinkedList(new int[]{1, 9, 1, 2, 4}), ListNode.arrayToLinkedList(new int[]{3, 2, 4})).val);
        System.out.println(new Solution().getIntersectionNode(ListNode.arrayToLinkedList(new int[]{2, 6, 4}), ListNode.arrayToLinkedList(new int[]{1, 5})).val);
    }
}