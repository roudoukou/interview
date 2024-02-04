package icu.xiamu.class1161;

import icu.xiamu.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
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
    public int maxLevelSum(TreeNode root) {
        return solve1(root);
    }

    private int solve1(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int ans = Integer.MIN_VALUE;
        int floor = 1;
        int maxFloor = 1;
        while (!queue.isEmpty()) {
            // TreeNode poll = queue.poll();
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right!= null) {
                    queue.offer(node.right);
                }

                if (i == size - 1) {
                    if (ans < sum) {
                        ans = sum;
                        maxFloor = floor;
                    }
                    floor++;
                    sum = 0;
                }
            }
        }

        return maxFloor;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxLevelSum(TreeNode.arrayToTreeNode(new Integer[]{-100,-200,-300,-20,-5,-10,null})));
        System.out.println(new Solution().maxLevelSum(TreeNode.arrayToTreeNode(new Integer[]{1, 7, 0, 7, -8, null, null})));
        System.out.println(new Solution().maxLevelSum(TreeNode.arrayToTreeNode(new Integer[]{989, null, 10250, 98693, -89388, null, null, null, -32127})));
    }
}