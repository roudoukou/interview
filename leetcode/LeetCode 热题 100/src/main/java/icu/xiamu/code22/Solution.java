package icu.xiamu.code22;

import icu.xiamu.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 * 160. 相交链表
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 * @author roudoukou
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 没有重写hashCode方法和equals方法, 存储节点的地址，然后判断地址是否相同
        Set<ListNode> set = new HashSet<>();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node6.next = node7;
        node7.next = node8;
        node8.next = node3;
        ListNode.printListNode(new Solution().getIntersectionNode(node1, node6));

        // 不能通过数组的方式构造链表，因为判题是根据节点是否在相同的地址空间
        // ListNode.printListNode(new Solution().getIntersectionNode(ListNode.arrayToListNode(new Integer[]{4, 1, 8, 4, 5}), ListNode.arrayToListNode(new Integer[]{5, 6, 1, 8, 4, 5})));
        // ListNode.printListNode(new Solution().getIntersectionNode(ListNode.arrayToListNode(new Integer[]{1, 9, 1, 2, 4}), ListNode.arrayToListNode(new Integer[]{3, 2, 4})));
        // ListNode.printListNode(new Solution().getIntersectionNode(ListNode.arrayToListNode(new Integer[]{2, 6, 4}), ListNode.arrayToListNode(new Integer[]{1, 5})));
    }
}