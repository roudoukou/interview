package icu.xiamu.year2023.class21;

import icu.xiamu.year2023.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/submissions/501131600/?envType=study-plan-v2&envId=top-100-liked
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return solve2(list1, list2);
    }

    /**
     * 2024-2-7 16:50:52
     * @param list1
     * @param list2
     * @return
     */
    private ListNode solve2(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();
        while (list1 != null) {
            list.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            list.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(list);

        ListNode head = new ListNode(0);
        ListNode current = head;
        for (Integer l : list) {
            current.next = new ListNode(l);
            current = current.next;
        }
        return head.next;
    }

    private ListNode solve1(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode list3 = new ListNode(-1);

        ListNode head = list3;

        while (list1 != null && list2 != null) {

            if (list1.val == list2.val) {
                // 将 node 节点添加到链表中
                list3.next = new ListNode(list1.val);
                list3 = list3.next;

                list3.next = new ListNode(list2.val);
                list3 = list3.next;

                // System.out.println(list1.val);
                // System.out.println(list2.val);
                list1 = list1.next;
                list2 = list2.next;

            } else if (list1.val > list2.val) {
                // 将 node 节点添加到链表中
                list3.next = new ListNode(list2.val);
                list3 = list3.next;

                // System.out.println(list2.val);
                list2 = list2.next;
            } else {
                // 将 node 节点添加到链表中
                list3.next = new ListNode(list1.val);
                list3 = list3.next;

                // System.out.println(list1.val);
                list1 = list1.next;
            }
        }

        // 处理后续节点
        while (list1 != null) {
            list3.next = new ListNode(list1.val);
            list3 = list3.next;

            list1 = list1.next;
        }

        while (list2 != null) {
            list3.next = new ListNode(list2.val);
            list3 = list3.next;

            list2 = list2.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode.printListNode(new Solution().mergeTwoLists(ListNode.arrayToLinkedList(new int[]{1,2,4}), ListNode.arrayToLinkedList(new int[]{1,3,4})));
    }
}