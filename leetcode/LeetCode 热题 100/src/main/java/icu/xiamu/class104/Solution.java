package icu.xiamu.class104;

import icu.xiamu.common.TreeNode;

/**
 * 104. 二叉树的最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=top-100-liked
 * <p>
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
        return solve2(root);
    }

    private int solve2(TreeNode root) {
        return process(root);
    }

    private int process(TreeNode root) {
        return root == null ? 0 : Math.max(process(root.left), process(root.right)) + 1;
    }

    private int solve1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+ Math.max(solve1(root.left), solve1(root.right));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxDepth(TreeNode.arrayToTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}