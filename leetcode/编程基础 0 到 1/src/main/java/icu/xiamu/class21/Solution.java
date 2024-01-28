package icu.xiamu.class21;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=programming-skills
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
        return solve1(list1, list2);
    }

    private ListNode solve1(ListNode list1, ListNode list2) {

        if (list1 == null) { return list2; }
        if (list2 == null) { return list1; }

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
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
        l5.next = l6;
        ListNode result1 = new Solution().mergeTwoLists(l1, l4);
        ListNode.printListNode(result1);

        ListNode l7 = null;
        ListNode l8 = null;
        ListNode result2 = new Solution().mergeTwoLists(l7, l8);
        ListNode.printListNode(result2);

        ListNode l9 = null;
        ListNode l10 = new ListNode(0);
        ListNode result3 = new Solution().mergeTwoLists(l9, l10);
        ListNode.printListNode(result3);

        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(1);
        ListNode result4 = new Solution().mergeTwoLists(l11, l12);
        ListNode.printListNode(result4);
    }
}