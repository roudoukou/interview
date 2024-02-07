package icu.xiamu.lcr.class123;

import icu.xiamu.lcr.common.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
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
    public int[] reverseBookList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode newHead = process(head);
        while (newHead != null) {
            list.add(newHead.val);
            newHead = newHead.next;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private ListNode process(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = process(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().reverseBookList(ListNode.arrayToLinkedList(new int[]{3, 6, 4, 1}))));
    }
}