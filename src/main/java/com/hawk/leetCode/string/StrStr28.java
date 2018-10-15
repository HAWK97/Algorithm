package com.hawk.leetCode.string;

/**
 * 题目描述：给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)
 * 如果不存在，则返回  -1
 * 示例：输入：haystack = "hello", needle = "ll" 输出：2 输入: haystack = "aaaaa", needle = "bba" 输出：-1
 */
public class StrStr28 {

    /**
     * 网上答案
     */
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                // 找到匹配的串
                if (j == needle.length()) {
                    return i;
                }
                // haystack 和 needle 同时遍历完毕，还未找到匹配的串
                if (i + j == haystack.length()) {
                    return -1;
                }
                // 遍历过程中存在不相同的字符时，重新取 haystack 的子串进行匹配
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }
}
