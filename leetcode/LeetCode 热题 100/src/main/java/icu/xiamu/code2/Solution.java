package icu.xiamu.code2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 字母异位词分组
 * <a href="https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {

            String sort = sort(str);
            if (!map.containsKey(sort)) {
                ArrayList<String> objects = new ArrayList<>();
                objects.add(str);
                map.put(sort, objects);
            } else {
                List<String> list = map.get(sort);
                if (sort(list.getFirst()).equals(sort)) {
                    list.add(str);
                    map.put(sort, list);
                }
            }
        }

        return map.values().stream().toList();
    }

    public String sort(String str) {
        return str.chars().mapToObj(c -> String.valueOf((char) c)).sorted().collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(new Solution().groupAnagrams(new String[]{""}));
        System.out.println(new Solution().groupAnagrams(new String[]{"a"}));
        System.out.println(new Solution().groupAnagrams(new String[]{"", ""}));
        System.out.println(new Solution().groupAnagrams(new String[]{"c", "c"}));
        System.out.println(new Solution().groupAnagrams(new String[]{"ac", "c"}));
        System.out.println(new Solution().groupAnagrams(new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"}));
    }
}