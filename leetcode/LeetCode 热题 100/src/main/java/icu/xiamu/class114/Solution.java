package icu.xiamu.class114;

import icu.xiamu.common.TreeNode;

import java.util.*;

/**
 * 114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/?envType=study-plan-v2&envId=top-100-liked
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
    // 不能直接创建树, 地址改变了, 妈的手动给你遍历上挨个赋值, root地址保持不变
    public void flatten(TreeNode root) {
        process(root);
        root.val = result.right.val;
        root.left = null;
        root.right = result.right == null ? null : result.right.right;
        TreeNode.show(root);
        // TreeNode.printLevelOrder(root);
    }

    TreeNode result = new TreeNode(-1);
    TreeNode current = result;

    private void process(TreeNode root) {
        if (root == null) return;

        // System.out.println(root.val);
        current.right = new TreeNode(root.val);
        current.left = null;
        current = current.right;

        process(root.left);
        process(root.right);
    }

    public static void main(String[] args) {
        new Solution().flatten(TreeNode.arrayToTreeNode(new Integer[]{1, 2, 5, 3, 4, null, 6}));
        new Solution().flatten(TreeNode.arrayToTreeNode(new Integer[]{}));
        new Solution().flatten(TreeNode.arrayToTreeNode(new Integer[]{0}));
    }
}