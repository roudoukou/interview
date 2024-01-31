package icu.xiamu.class2130;

import icu.xiamu.common.ListNode;

/**
 * https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/?envType=study-plan-v2&envId=leetcode-75
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
    public int pairSum(ListNode head) {
        return solve1(head);
    }

    private int solve1(ListNode head) {
        int[] nums = new int[100_000];
        int index = 0;
        while (head != null) {
            nums[index++] = head.val;
            head = head.next;
        }

        // 双指针, 前后遍历 取最大值
        int maxValue = Integer.MIN_VALUE;

        int left = 0;
        int right = index - 1;
        while (left <= right) {
            if (maxValue < nums[left] + nums[right]) {
                maxValue = nums[left] + nums[right];
            }
            left++;
            right--;
        }

        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pairSum(ListNode.arrayToLinkedList(new int[]{5, 4, 2, 1})));
        System.out.println(new Solution().pairSum(ListNode.arrayToLinkedList(new int[]{4, 2, 2, 3})));
        System.out.println(new Solution().pairSum(ListNode.arrayToLinkedList(new int[]{1, 100000})));
    }
}