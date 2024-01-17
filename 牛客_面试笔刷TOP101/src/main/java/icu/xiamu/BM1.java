package icu.xiamu;

/**
 * 2023-6-23
 */
public class BM1 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode ReverseList(ListNode head) {
        // write code here
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;

            // 往后移动一个位置
            prev = current;
            current = next;

            // 打印测试
            // System.out.println();
            // System.out.println("ReverseList: ");
            // printListNode(prev);
        }
        return prev;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printListNode(ListNode head) {
        // 打印链表
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode head = node1;
        node1.next = node2;
        node2.next = node3;


        printListNode(head);
        head = ReverseList(head);
        System.out.println();
        printListNode(head);
    }
}


