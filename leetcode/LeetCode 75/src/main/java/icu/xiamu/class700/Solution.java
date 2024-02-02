package icu.xiamu.class700;

import icu.xiamu.common.TreeNode;

/**
 *
 * https://leetcode.cn/problems/search-in-a-binary-search-tree/?envType=study-plan-v2&envId=leetcode-75
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
    public TreeNode searchBST(TreeNode root, int val) {
        return solve2(root, val);
    }

    private TreeNode solve2(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return solve1(root.left, val);
        } else {
            return solve1(root.right, val);
        }
    }

    /**
     * 相当于 左右两边都搜索了, 其实可以稍微优化一下
     *
     * @param root
     * @param val
     * @return
     */
    private TreeNode solve1(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode t1 = solve1(root.left, val);
        if (t1 != null) {
            return t1;
        }

        TreeNode t2 = solve1(root.right, val);
        if (t2 != null) {
            return t2;
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode.show(new Solution().searchBST(TreeNode.arrayToTreeNode(new Integer[]{4, 2, 7, 1, 3}), 2));
        TreeNode.show(new Solution().searchBST(TreeNode.arrayToTreeNode(new Integer[]{4, 2, 7, 1, 3}), 5));
    }
}