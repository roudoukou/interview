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
     *
     * @param head 头节点
     */
    public static void printListNode(ListNode head) {
        if (head == null) {
            System.out.print("head: null\n");
            return;
        }
        System.out.print("head: ");
        while (head != null) {
            System.out.print(head.val + " => ");
            head = head.next;
        }
        System.out.println("\b\b\b");
    }

    /**
     * 将数组转换成链表
     *
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
     *
     * @return 将尾结点作为头结点返回
     */
    public ListNode reverseList() {
        return ListNode.reverseList(this);
    }

    /**
     * 反转链表, 原head会到尾结点的位置
     * 如果想保留原head, 先拷贝一份链表
     *
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

    /**
     * 比较两个链表是否相等
     * @param p head1
     * @param q head2
     * @return boolean
     */
    public static boolean isSameListNode(ListNode p, ListNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameListNode(p.next, q.next);
    }

    /**
     * isPalindrome
     * 比较当前链表是否是回文链表
     * 使用快慢指针
     */
    public static boolean isPalindrome(ListNode head) {
        return false;
    }

    /**
     * 拷贝一份ListNode
     */
    private ListNode copyLinkedList(ListNode head) {
        ListNode current = new ListNode(-1);
        ListNode newHead = current;
        while (head != null) {
            current.next = new ListNode(head.val);
            current = current.next;
            head = head.next;
        }
        return newHead.next;
    }
}