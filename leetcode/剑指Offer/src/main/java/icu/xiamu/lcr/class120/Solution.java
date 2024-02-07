package icu.xiamu.lcr.class120;

import java.util.*;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
class Solution {
    public int findRepeatDocument(int[] documents) {
        return solve3(documents);
    }

    /**
     * 妈的, 借助list不行, 还是看set
     * @param documents
     * @return
     */
    private int solve3(int[] documents) {
        Set<Integer> set = new HashSet<>();
        for (int document : documents) {
            if (set.contains(document)) {
                return document;
            }
            set.add(document);
        }
        return -1;
    }

    /**
     * 排个序, 比较相邻两个元素
     * @param documents
     * @return
     */
    private int solve2(int[] documents) {
        Arrays.sort(documents);

        for (int i = 1; i < documents.length; i++) {
            if (documents[i-1] == documents[i]) {
                return documents[i];
            }
        }

        return -1;
    }

    /**
     * 借助list的contain方法判断, 超时妈的,
     * @param documents
     * @return
     */
    private static int solve1(int[] documents) {
        List<Integer> list = new ArrayList<>();
        for (int document : documents) {
            if (list.contains(document)) {
                return document;
            }
            list.add(document);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findRepeatDocument(new int[]{2, 5, 3, 0, 5, 0}));
    }
}