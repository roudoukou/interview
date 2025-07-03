package icu.xiamu.year2023.class148;

import icu.xiamu.year2023.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/sort-list/submissions/?envType=study-plan-v2&envId=top-100-liked
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        return solve1(head);
    }

    private ListNode solve1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode current = new ListNode(0);
        ListNode newHead = current;
        for (Integer l : list) {
            current.next = new ListNode(l);
            current = current.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode.printListNode(new Solution().sortList(ListNode.arrayToLinkedList(new int[]{4, 2, 1, 3})));
    }
}