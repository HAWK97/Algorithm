package com.hawk.leetCode.string;

/**
 * 题目描述：给定一个字符串，找出不含有重复字符的最长子串的长度
 * 示例：s = "leetcode"，返回 0；s = "loveleetcode"，返回 2
 */
public class FirstUniqChar387 {

    /**
     * 网上答案
     */
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < freq.length; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
