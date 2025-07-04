package icu.xiamu.year2023.common;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 数组转树
     *
     * @param array
     * @return
     */
    public static TreeNode arrayToTreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek(); // 取出队列首结点, 不删除
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll(); // 弹出队列首结点, 删除
                isLeft = true;
            }
        }
        return root;
    }

    /**
     * 数组转二叉树, 数组不能简写
     * [2,null,4,null,null,9,8,null,null,null,null,null,null,4] √
     * [2,null,4,9,8,null,null,4]                               ×
     * <pre>
     *     2
     * null    4
     *       9   8
     *         4
     * <pre/>
     * @param array
     * @param index
     * @return
     */
    private static TreeNode arrayToTreeNode(Integer[] array, int index) {
        if (index >= array.length || array[index] == null) {
            return null;
        }
        return new TreeNode(array[index], arrayToTreeNode(array, index * 2 + 1), arrayToTreeNode(array, index * 2 + 2));
    }

    // 用于获得树的层数
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }

    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

    /**
     * 参考地址: https://jueee.github.io/2021/03/2021-03-05-Java%E6%8C%89%E7%85%A7%E6%A0%91%E5%BD%A2%E7%BB%93%E6%9E%84%E6%89%93%E5%8D%B0%E4%BA%8C%E5%8F%89%E6%A0%91/
     *
     * @param root 根节点
     */
    public static void show(TreeNode root) {
        if (root == null) {
            System.out.println("EMPTY!");
            return;
        }
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }

    }

    /**
     * 递归基本样子, 用来理解递归序
     *
     * @param head
     */
    private static void f(TreeNode head) {
        if (head == null) {
            return;
        }
        // 1
        f(head.left);
        // 2
        f(head.right);
        // 3
    }

    /**
     * 前序遍历
     * @param head
     */
    public static void printPreOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        printPreOrder(head.left);
        printPreOrder(head.right);
    }

    /**
     * 中序遍历
     * @param head
     */
    public static void printInOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        printInOrder(head.left);
        System.out.print(head.val + " ");
        printInOrder(head.right);
    }

    /**
     * 后序遍历
     * @param head
     */
    public static void printPostOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        printPostOrder(head.left);
        printPostOrder(head.right);
        System.out.print(head.val + " ");
    }

    /**
     * 广度遍历
     * 无返回值, 如需返回值, 用List接收返回
     * @param head
     */
    public static List<Integer> printLevelOrder(TreeNode head) {
        if (head == null) return Collections.emptyList();

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println();
        return list;
    }
}
