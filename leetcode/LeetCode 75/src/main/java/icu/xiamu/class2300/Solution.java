package icu.xiamu.class2300;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        return solve1(spells, potions, success);
    }

    /**
     * 对potions二分, 暂时没写出来...qwq
     *
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    private int[] solve2(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);
        int[] answer = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int count = 0;
            int left = 0;
            int right = potions.length - 1;

            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if ((long) spells[i] * potions[mid] >= success) {
                    count +=  (right - left + 1) * spells.length;
                } else {

                }
            }

            answer[i] = count;
        }
        return answer;
    }

    /**
     * 直接暴力算法, 超时
     * potions的遍历过于浪费时间, 采用二分的方式进行比较
     *
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    private int[] solve1(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);
        int[] answer = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int count = 0;
            for (int j = 0; j < potions.length; j++) {
                if ((long) spells[i] * potions[j] >= success) {
                    if (j == 0) {
                        count += potions.length;
                        break;
                    } else {
                        count++;
                    }
                }
            }
            answer[i] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().successfulPairs(new int[]{15, 8, 19}, new int[]{38, 36, 23}, 328)));
        System.out.println(Arrays.toString(new Solution().successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(new Solution().successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));
        System.out.println(Arrays.toString(new Solution().successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));
    }
}