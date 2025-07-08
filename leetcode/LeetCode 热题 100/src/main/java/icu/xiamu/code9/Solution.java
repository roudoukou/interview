package icu.xiamu.code9;

import javax.lang.model.type.IntersectionType;
import java.awt.image.renderable.RenderableImageOp;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 438. 找到字符串中所有字母异位词
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    /**
     * 感觉是个固定长度的滑动窗口
     *
     * @param s 长串
     * @param p 匹配串
     * @return 结果
     */
    public List<Integer> findAnagrams(String s, String p) {


        List<Integer> result = new ArrayList<>();
        int length = s.length();
        int left = 0;
        int right = 0;

        p = sortString(p);


        while (right <= s.length()) {

            if (right - left == p.length()) {
                String substring = sortString(s.substring(left, right));
                if (substring.equals(p)) {
                    result.add(left);
                }
                left++;
            }

            right++;
        }

        return result;
    }

    private String sortString(String p) {
        char[] charArray = p.toCharArray();
        Arrays.sort(charArray);
        p = new String(charArray);
        return p;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Solution().findAnagrams("cbaebabacd", "cba"));
        System.out.println(new Solution().findAnagrams("abab", "ab"));
    }
}