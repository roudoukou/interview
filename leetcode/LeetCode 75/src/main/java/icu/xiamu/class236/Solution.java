package icu.xiamu.class236;

import icu.xiamu.common.TreeNode;

/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process1(root, p, q);
    }

    private TreeNode process1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.left != null && root.right != null) {
            System.out.println("root: " + root.val + " left: " + root.left.val + " right: " + root.right.val);
        }
        process1(root.left, p, q);
        process1(root.right, p, q);

        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lowestCommonAncestor(TreeNode.arrayToTreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), new TreeNode(1)).val);
        System.out.println(new Solution().lowestCommonAncestor(TreeNode.arrayToTreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), new TreeNode(4)).val);
        System.out.println(new Solution().lowestCommonAncestor(TreeNode.arrayToTreeNode(new Integer[]{1, 2}), new TreeNode(1), new TreeNode(2)).val);
    }
}