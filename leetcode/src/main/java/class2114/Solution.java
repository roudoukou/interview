package main.java.class2114;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int mostWordsFound(String[] sentences) {
        return Arrays.stream(sentences)
                .map(sentence -> sentence.split(" ").length)
                .max(Integer::compare).get();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mostWordsFound(new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"}));
        System.out.println(new Solution().mostWordsFound(new String[]{"please wait", "continue to fight", "continue to win"}));
    }
}