package icu.xiamu.class445;

import icu.xiamu.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/add-two-numbers-ii/?envType=study-plan-v2&envId=programming-skills
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // l1 长的
        // l2 短的
/*
        int length1 = getLength(l1);
        int length2 = getLength(l2);

        if (length1 >= length2) {
            return solve1(l1, l2, length1 - length2);
        } else {
            return solve1(l2, l1, length2 - length1);
        }
*/

/*
        int length1 = getLength(l1);
        int length2 = getLength(l2);

        if (length1 >= length2) {
            return solve2(l1, l2, length1, length2);
        } else {
            return solve2(l2, l1, length2, length1);
        }
*/

        int length1 = getLength(l1);
        int length2 = getLength(l2);

        if (length1 >= length2) {
            return solve3(l1, l2, length1, length2);
        } else {
            return solve3(l2, l1, length2, length1);
        }
    }

    private ListNode solve3(ListNode l1, ListNode l2, int length1, int length2) {
        // 特殊值判断
        if (l1.val == 0) {
            return l2;
        }
        if (l2.val == 0) {
            return l1;
        }

        ListNode listNode = new ListNode(0);
        listNode.next = l1;

        l1 = reverseList(listNode);
        l2 = reverseList(l2);
        ListNode head = l1;

        // 3427
        // 465
        int font = 0;
        while (l1 != null && l2 != null) {
            int currentValue = l1.val + l2.val + font;
            font = 0;
            if (currentValue >= 10) {
                font = currentValue / 10;
                currentValue = currentValue % 10;
            }
            l1.val = currentValue;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int currentValue = l1.val + font;
            font = 0;
            if (currentValue >= 10) {
                font = currentValue / 10;
                currentValue = currentValue % 10;
            }
            l1.val = currentValue;

            l1 = l1.next;
        }


        head = reverseList(head);

        if (font != 0) {
            head.val += font;
        }

        if (head.val != 0) {
            return head;
        } else {
            return head.next;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 借助数组
     *
     * @param l1
     * @param l2
     * @param index1
     * @param index2
     * @return
     */
    private ListNode solve2(ListNode l1, ListNode l2, int index1, int index2) {

        // 特殊值判断
        if (l1.val == 0) {
            return l2;
        }
        if (l2.val == 0) {
            return l1;
        }

        int length = index1 + 1;

        // 直接使用数组简单粗暴
        int[] nums1 = new int[length];
        int[] nums2 = new int[length];

        while (index1-- != 0) {
            nums1[index1] = l1.val;
            l1 = l1.next;
        }

        while (index2-- != 0) {
            nums2[index2] = l2.val;
            l2 = l2.next;
        }

        int font = 0;
        int currentValue = 0;
        for (int i = 0; i < length; i++) {
            currentValue = nums1[i] + nums2[i] + font;
            font = 0;
            if (currentValue >= 10) {
                font = currentValue / 10;
                currentValue %= 10;
            }
            nums1[i] = currentValue;
        }

        // nums => listNode
        ListNode current = new ListNode(0);
        ListNode head = current;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (i == nums1.length - 1 && nums1[i] == 0) {
                continue;
            }
            current.next = new ListNode(nums1[i]);
            current = current.next;
        }

        return head.next;
    }

    /**
     * 有bug, 进位两次没法算
     * 进位在中间 [8, 10, 1] => [9, 0, 1]
     *
     * @param l1
     * @param l2
     * @param diff
     * @return
     */
    private ListNode solve1(ListNode l1, ListNode l2, int diff) {

        // 特殊值判断
        if (l1.val == 0) {
            return l2;
        }
        if (l2.val == 0) {
            return l1;
        }

        // 2 4 3
        // 5 6 4
        // 表示上一个节点
        ListNode lastNode = new ListNode(0);
        ListNode head = lastNode;
        lastNode.next = l1;
        for (int i = diff; i != 0; i--) {
            lastNode = lastNode.next;
            l1 = l1.next;
        }

        // 处理相同长度
        while (l1 != null) {
            int lastValue = 0;
            int currentValue = l1.val + l2.val + lastValue;
            if (currentValue >= 10) {
                lastValue = currentValue / 10;
                currentValue = currentValue % 10;
            }
            l1.val = currentValue;
            lastNode.val += lastValue;

            lastNode = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        // 判断前导零, 以及首位的判断
        if (head.val == 0) {
            head = head.next;
        }

        // 遍历解决,特殊情况  [10, 0] => [1, 0, 0]
        // [20] => [2, 0, 0]
        // 进位在第一个
        ListNode current = head;
        while (diff-- != 0) {
            ListNode node = null;
            if (current.val >= 10) {
                node = new ListNode(current.val % 10);
                current.val = current.val / 10;
                node.next = current.next;
                current.next = node;
            }
        }

        // 进位在中间 [8, 10, 1] => [9, 0, 1]

        return head;
    }

    /**
     * 获取链表长度
     *
     * @param head
     * @return
     */
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode.printListNode(new Solution().addTwoNumbers(
                ListNode.arrayToLinkedList(new int[]{1}),
                ListNode.arrayToLinkedList(new int[]{9, 9})
        ));
        ListNode.printListNode(new Solution().addTwoNumbers(
                ListNode.arrayToLinkedList(new int[]{5}),
                ListNode.arrayToLinkedList(new int[]{5})
        ));
        ListNode.printListNode(new Solution().addTwoNumbers(
                ListNode.arrayToLinkedList(new int[]{8, 9, 9}),
                ListNode.arrayToLinkedList(new int[]{2})
        ));
        ListNode.printListNode(new Solution().addTwoNumbers(
                ListNode.arrayToLinkedList(new int[]{7, 2, 4, 3}),
                ListNode.arrayToLinkedList(new int[]{5, 6, 4})
        ));
        ListNode.printListNode(new Solution().addTwoNumbers(
                ListNode.arrayToLinkedList(new int[]{9, 1, 6}),
                ListNode.arrayToLinkedList(new int[]{0})
        ));
        ListNode.printListNode(new Solution().addTwoNumbers(
                ListNode.arrayToLinkedList(new int[]{2, 4, 3}),
                ListNode.arrayToLinkedList(new int[]{5, 6, 4})
        ));
        ListNode.printListNode(new Solution().addTwoNumbers(
                ListNode.arrayToLinkedList(new int[]{0}),
                ListNode.arrayToLinkedList(new int[]{0})
        ));
    }
}