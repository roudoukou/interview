package icu.xiamu.class21;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
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
}