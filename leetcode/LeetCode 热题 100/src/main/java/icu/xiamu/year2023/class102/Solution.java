package icu.xiamu.year2023.class102;

import icu.xiamu.year2023.common.TreeNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return solve1(root);
    }

    private List<List<Integer>> solve1(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int index = 1; // 表示高度
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println();
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().levelOrder(TreeNode.arrayToTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
        // System.out.println(new Solution().levelOrder(TreeNode.arrayToTreeNode(new Integer[]{1})));
        // System.out.println(new Solution().levelOrder(TreeNode.arrayToTreeNode(new Integer[]{})));
    }
}