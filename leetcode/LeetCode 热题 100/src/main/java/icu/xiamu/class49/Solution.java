package icu.xiamu.class49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return solve1(strs);
    }

    private List<List<String>> solve1(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String sort = sort(strs[i]);
            if (hashMap.containsKey(sort)) {
                List<String> list = hashMap.get(sort);
                list.add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                hashMap.put(sort, list);
            }
        }

        // List<List<String>> collect = hashMap.values().stream().collect(Collectors.toList());
        return new ArrayList<>(hashMap.values());
    }

    private String sort(String oldString) {
        char[] chars = oldString.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(new Solution().groupAnagrams(new String[]{""}));
        System.out.println(new Solution().groupAnagrams(new String[]{"a"}));
    }
}