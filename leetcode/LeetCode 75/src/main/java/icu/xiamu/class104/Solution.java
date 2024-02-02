package icu.xiamu.class104;

import icu.xiamu.common.TreeNode;

import java.util.TreeMap;

/**
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 *
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
    public int maxDepth(TreeNode root) {
        return solve1(root);
    }

    private int solve1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+ Math.max(solve1(root.left), solve1(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.arrayToTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        TreeNode.show(root);
        System.out.println(new Solution().maxDepth(root));
    }
}