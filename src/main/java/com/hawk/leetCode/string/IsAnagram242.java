package com.hawk.leetCode.string;

/**
 * 题目描述：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词
 * 示例：输入：s = "anagram", t = "nagaram" 输出：true 输入: s = "rat", t = "car" 输出：false
 */
public class IsAnagram242 {

    /**
     * 我的答案
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
