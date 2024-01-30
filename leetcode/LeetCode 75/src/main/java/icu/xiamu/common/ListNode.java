package icu.xiamu.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 打印链表
     * @param head 头节点
     */
    public static void printListNode(ListNode head) {
        if (head == null) {
            System.out.print("head: null\n");
            return;}
        System.out.print("head: ");
        while (head != null) {
            System.out.print(head.val + " => ");
            head = head.next;
        }
        System.out.println("\b\b\b");
    }

    /**
     * 将数组转换成链表
     * @param nums 要转换的数组
     * @return 数组第零个元素作为头节点
     */
    public static ListNode arrayToLinkedList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode current = head;

        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return head.next;
    }

    /**
     * @param head 头结点
     * @return 返回单链表节点个数
     */
    public static int getSize(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    /**
     * 反转链表
     * @return 将尾结点作为头结点返回
     */
    public ListNode reverseList() {
        return ListNode.reverseList(this);
    }

    /**
     * 反转链表
     * @param head 头结点
     * @return 将尾结点作为头结点返回
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}