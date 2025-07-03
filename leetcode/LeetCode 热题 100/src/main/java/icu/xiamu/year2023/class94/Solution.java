package icu.xiamu.year2023.class94;

import icu.xiamu.year2023.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        process(result, root);
        return result;
    }

    private void process(List<Integer> result, TreeNode root) {

        if (root == null) return;
        process(result, root.left);
        result.add(root.val);
        process(result, root.right);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().inorderTraversal(TreeNode.arrayToTreeNode(new Integer[]{1, null, 2, 3})));
        System.out.println(new Solution().inorderTraversal(TreeNode.arrayToTreeNode(new Integer[]{})));
        System.out.println(new Solution().inorderTraversal(TreeNode.arrayToTreeNode(new Integer[]{1})));
    }
}