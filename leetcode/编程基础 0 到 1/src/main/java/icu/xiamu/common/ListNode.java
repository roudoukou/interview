package icu.xiamu.common;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

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
}