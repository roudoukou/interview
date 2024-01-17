package icu.xiamu;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 镜子电报充电包充电
 * 2023-6-24 22:10:23
 */

public class BM2 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 遍历head

        Set<Integer> set = new LinkedHashSet<>();

        while (head != null) {
            set.add(head.val);
            head = head.next;
        }

        /*if (set.size() <= 0) {
            return null;
        }

        ListNode result = new ListNode(set.stream().findFirst().orElse(null));

        if (set.size() <= 1) {
            return result;
        }*/

        ListNode result = null;
        ListNode current = null;
        int count = 0;

        // 遍历set集合
        for (Integer s : set) {
            if (count == 0) {
                // 第一个节点
                current = new ListNode(s);
                // 记录下第一个节点
                result = current;
            } else {
                ListNode next = new ListNode(s);
                // 将下一个节点加进来
                current.next = next;
                // 移动头节点到下一个节点
                current = current.next;
                // System.out.println(s);
            }
            count++;
        }

        return result;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode listNode = new BM2().deleteDuplicates(node1);
        printListNode(listNode);

    }
}

//{1,-3,2,-5,-6,5,6,-8,-9,-10,9,-11,-13,-14,13,-16,15,-17,17,-19,-20,19,-24,23,-25,24,25,-27,26,27,29,-31,30,-33,32,-35,35,36,-38,37,-40,39,-41,40,-42,-43,-44,45,-48,-49,-51,50,-54,53,54,-56,-57,56,-58,-59,-60,62,63,64,-66,65,67,-69,68,-71,70,71,-73,72,-74,73,-78,77,-79,78,-81,80,82,83,84,-86,-87,86,-88,-89,88,-92,93,95,-97,96,-98,-99,98,99}
//{-99,-98,-97,-92,-89,-88,-87,-86,-81,-79,-78,-74,-73,-71,-69,-66,-60,-59,-58,-57,-56,-54,-51,-49,-48,-44,-43,-42,-41,-40,-38,-35,-33,-31,-27,-25,-24,-20,-19,-17,-16,-14,-13,-11,-10,-9,-8,-6,-5,-3,1,2,5,6,9,13,15,17,19,23,24,25,26,27,29,30,32,35,36,37,39,40,45,50,53,54,56,62,63,64,65,67,68,70,71,72,73,77,78,80,82,83,84,86,88,93,95,96,98,99}









