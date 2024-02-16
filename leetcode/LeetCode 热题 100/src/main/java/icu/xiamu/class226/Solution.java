package icu.xiamu.class226;

import icu.xiamu.common.TreeNode;

/**
 * 226. 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
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
    // 直接遍历 , 然后交换左节点和右节点
    public TreeNode invertTree(TreeNode root) {
        process1(root);
        return root;
    }

    /**
     * 理解题意错了, 俺还以为是左节点跟右节点互换位置, 是将这一层的节点都要互换, 应该层次遍历才对
     * @param root
     * @return
     */
    private boolean process1(TreeNode root) {

        if (root == null) return false;

        boolean p1 = process1(root.left);
        boolean p2 = process1(root.right);

        if (p1 && p2) {
            // right and left is not null
            int temp = root.right.val;
            root.right.val = root.left.val;
            root.left.val = temp;
        } else if (p1) {
            // left is null
            int temp = root.right.val;
            root.right = null;
            root.left = new TreeNode(temp);
        } else if (p2) {
            // right is null
            int temp = root.left.val;
            root.left = null;
            root.right = new TreeNode(temp);
        } else {
            // left and right is null

        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode.printLevelOrder(new Solution().invertTree(TreeNode.arrayToTreeNode(new Integer[]{4, 2, 7, 1, 3, 6, 9})));
        TreeNode.printLevelOrder(new Solution().invertTree(TreeNode.arrayToTreeNode(new Integer[]{2, 1, 3})));
        TreeNode.printLevelOrder(new Solution().invertTree(TreeNode.arrayToTreeNode(new Integer[]{})));
    }

}