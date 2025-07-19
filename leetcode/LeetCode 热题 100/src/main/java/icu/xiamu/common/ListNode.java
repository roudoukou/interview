package icu.xiamu.common;

import com.sun.source.tree.NewArrayTree;
import org.apache.http.Header;

import javax.swing.plaf.LabelUI;

/**
 * @author roudoukou
 * @date 2025/7/19
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }


    public static ListNode arrayToListNode(Integer [] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode preNode = head;

        for (Integer num : nums) {
            ListNode next = new ListNode(num);
            head.next = next;
            head = next;
        }

        return preNode.next;
    }

    public static void printListNode(ListNode head) {
        if (head == null) {
            System.out.println("head: null");
            return;
        }
        System.out.print("head: ");
        while (head != null) {
            System.out.print(head.val + " => ");
            head = head.next;
        }
        System.out.println("\b\b\b\b");
    }


}
