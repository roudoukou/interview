package icu.xiamu.class199;

import icu.xiamu.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=leetcode-75
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
    public List<Integer> rightSideView(TreeNode root) {
        TreeNode.show(root);
        return solve2(root);
    }

    private List<Integer> solve2(TreeNode root) {

        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) { // 处理掉当前的节点 下一级所有节点
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (i == size - 1) {
                    list.add(node.val); // 将末尾的最后一个元素进行保存下来
                }
            }
        }

        return list;
    }


    /**
     * 深度优先遍历 (从右边开始遍历)
     *
     * @param root
     * @return
     */
    private List<Integer> solve1(TreeNode root) {

        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int treeDepth = getTreeDepth(root);
        int[] dp = new int[treeDepth];
        Arrays.fill(dp, -1);
        // 3 2 1
        process(root, dp, 0);

        return Arrays.stream(dp).boxed().collect(Collectors.toList());
    }

    private TreeNode process(TreeNode root, int[] dp, int index) {
        if (root == null) {
            return null;
        }
        if (dp[index] == -1) {
            dp[index] = root.val;
        }
        // System.out.print(root.val + " ");
        TreeNode p2 = process(root.right, dp, index + 1);
        if (p2 == null) {
            TreeNode p1 = process(root.left, dp, index + 1);
            if (p1 == null) {
                return null;
            }
        }

        return root;
    }

    private int getTreeDepth(TreeNode root) {
        return root == null ? 0 : Math.max(getTreeDepth(root.left), getTreeDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rightSideView(TreeNode.arrayToTreeNode(new Integer[]{1, 2, 3, null, 5, null, 4})));
        // System.out.println(new Solution().rightSideView(TreeNode.arrayToTreeNode(new Integer[]{1, null, 3})));
        // System.out.println(new Solution().rightSideView(TreeNode.arrayToTreeNode(new Integer[]{})));
        // System.out.println(new Solution().rightSideView(TreeNode.arrayToTreeNode(new Integer[]{1, 2, 3, null, 5, null})));
        // System.out.println(new Solution().rightSideView(TreeNode.arrayToTreeNode(new Integer[]{1, 2, 0})));
    }
}