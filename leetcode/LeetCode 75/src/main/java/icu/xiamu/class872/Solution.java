package icu.xiamu.class872;

import icu.xiamu.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        process1(root1);
        process2(root2);

        return Arrays.equals(leaf1.toArray(), leaf2.toArray());
    }

    List<Integer> leaf1 = new ArrayList<>();
    List<Integer> leaf2 = new ArrayList<>();

    /**
     * 中序遍历 获得叶子节点
     *
     * @param head
     * @return
     */
    private void process1(TreeNode head) {
        if (head == null) {
            return;
        }

        if (head.left == null && head.right == null) {
            leaf1.add(head.val);
        }

        process1(head.left);
        process1(head.right);
    }

    private void process2(TreeNode head) {
        if (head == null) {
            return;
        }

        if (head.left == null && head.right == null) {
            leaf2.add(head.val);
        }

        process2(head.left);
        process2(head.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.arrayToTreeNode(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
        TreeNode root2 = TreeNode.arrayToTreeNode(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8});
        // TreeNode.show(root);
        System.out.println(new Solution().leafSimilar(root1, root2));

        root1 = TreeNode.arrayToTreeNode(new Integer[]{1, 2, 3});
        root2 = TreeNode.arrayToTreeNode(new Integer[]{1, 3, 2});
        // TreeNode.show(root);
        System.out.println(new Solution().leafSimilar(root1, root2));
    }
}