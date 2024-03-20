package icu.xiamu.class101;

import icu.xiamu.common.TreeNode;

import javax.swing.plaf.ProgressBarUI;

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return process1(root.left, root.right);
    }

    private boolean process1(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return process1(left.left, right.right) && process1(left.right, right.left);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSymmetric(TreeNode.arrayToTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        System.out.println(new Solution().isSymmetric(TreeNode.arrayToTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3})));
    }
}