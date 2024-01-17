package icu.xiamu;

import java.util.HashSet;
import java.util.Set;

public class BM10 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        return solve1(pHead1, pHead2);
    }

    /**
     * 此方法作废, 因为
     * 1 2 5 6 7
     * 2 6 7
     * 最后返回的结果是2, 不是6 7
     *
     * 1.使用set集合来完成
     * 2.判断set有无此节点
     * 3.若无, 将链表1中的节点加到set中
     * 4.判断set有无此节点
     * 5.将链表2中的节点加到set中
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    private ListNode solve2(ListNode pHead1, ListNode pHead2) {
        Set<Integer> set = new HashSet<>();
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != null) {
            set.add(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            if (set.contains(p2.val)) {
                return p2;
            }
            p2 = p2.next;
        }

        return null;
    }

    /**
     * 参考resource/BM16动图
     * 1.通过将两段指针进行遍历
     * 2.可能会出现没有公共的点, 要想办法跳出死循环
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    private ListNode solve1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int count = 0;
        while (true) {

            if (p1.val == p2.val) {
                break;
            }

            p1 = p1.next;
            p2 = p2.next;

            if (p1 == null) {
                p1 = pHead2;
                count++;
            }
            if (p2 == null) {
                p2 = pHead1;
                count++;
            }

            // 计数器, 防止卡死
            if (count > 10) {
                return null;
            }

        }
        return p1;
    }

    public static void main(String[] args) {
        /*int[] list1 = {1, 2, 3, 6, 7};
        int[] list2 = {4, 5, 6, 7};*/
        /*int[] list1 = {1,2,3,4,5};
        int[] list2 = {1,2,3,4,5};*/
        /*int[] list1 = {1, 2};
        int[] list2 = {5, 6, 7};*/
        int[] list1 = {1, 6, 7};
        int[] list2 = {4, 5, 6, 7};
        ListNode pHead1 = ListNode.createListNode(list1);
        ListNode pHead2 = ListNode.createListNode(list2);
        ListNode resultNode = new BM10().FindFirstCommonNode(pHead1, pHead2);
        ListNode.printListNode(resultNode);
    }
}
