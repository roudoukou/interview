package icu.xiamu;

import java.util.Stack;

public class BM8 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        return solve3(pHead, k);
    }

    /**
     * 引入额外的空间, 使用栈进行
     * @param pHead
     * @param k
     * @return
     */
    private ListNode solve3(ListNode pHead, int k) {
        // 获取长度
        ListNode current = pHead;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }

        if (length < k) {
            return null;
        }

        Stack<ListNode> listNodes = new Stack<>();
        ListNode resultNodes = null;
        current = pHead;
        for (int i = 0 ; i < length; i++) {
            listNodes.push(current);
            current = current.next;
        }

        for (int i = 0; i < k; i++) {
            resultNodes = listNodes.pop();
        }

        ListNode.printListNode(resultNodes);

        return resultNodes;
    }


    /**
     * 使用快慢指针, 快指针先移动k步, 然后快慢指针同步
     * @param pHead
     * @param k
     * @return
     */
    private ListNode solve2(ListNode pHead, int k) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        // 快指针先走k步
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }

        // 然后快慢指针同步走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // ListNode.printListNode(fast);
        // ListNode.printListNode(slow);
        return slow;
    }

    /**
     * 先获取链表长度, 直接遍历
     * @param pHead
     * @param k
     * @return
     */
    private ListNode solve1(ListNode pHead, int k) {
        // 获取链表长度
        ListNode current = pHead;
        int count = 0;
        int length = 0;

        // 获取长度
        while (current != null) {
            length++;
            current = current.next;
        }

        if (length < k) {
            return null;
        }

        // 接收答案
        ListNode resultNode = null;
        current = pHead;
        while (current != null) {
            if (count >= length - k) {
                resultNode = current;
                break;
            }
            count++;
            current = current.next;
        }
        ListNode.printListNode(resultNode);
        return resultNode;
    }



    public static void main(String[] args) {
        /*ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;*/

        int[] nodeValues = {1, 2, 3, 4, 5};
        // int[] nodeValues = {2};
        /*ListNode head = new ListNode(nodeValues[0]);
        ListNode current = head;

        for (int i = 1; i < nodeValues.length; i++) {
            current.next = new ListNode(nodeValues[i]);
            current = current.next;
        }*/
        ListNode head = ListNode.createListNode(nodeValues);

        ListNode.printListNode(head);

        new BM8().FindKthToTail(head, 2);


    }
}
