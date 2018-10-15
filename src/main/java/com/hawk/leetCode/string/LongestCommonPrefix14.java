package com.hawk.leetCode.string;

/**
 * 题目描述：编写一个函数来查找字符串数组中的最长公共前缀，如果不存在公共前缀，返回空字符串""
 * 示例：输入: ["flower","flow","flight"] 输出："fl" 输入: ["dog","racecar","car"] 输出：""
 */
public class LongestCommonPrefix14 {

    /**
     * 横向扫描法
     * 解题思路：该算法需要遍历字符串数组 [S1...Sn]，在第 i 次遍历过程中查找出 [S1...Si] 的最长公共前缀
     * 当 LCP(S1...Si) 查找出来的最长公共前缀是空串时，算法结束
     * 否则，经过 n 次遍历，该算法就可以找出 [S1...Sn] 的最长公共前缀
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // indexOf 方法：当存在公共子串时返回 >= 0，不存在公共子串时返回 -1
            while (strs[i].indexOf(prefix) != 0) {
                // 缩减公共子串的长度再进行查找
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 纵向扫描法
     * 解题思路：在移动到下一列之前，从上到下比较同一列的字符
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            // 获得第一行 i 列的字符
            char c = strs[0].charAt(i);
            // 依次比较剩余行相同列的字符
            for (int j = 1; j < strs.length; i++) {
                // 若 j 行 i 列的字符与第一行 i 列的字符不同
                // 或第一行 i 列已经超出了剩余行的最大列数（这个要放在前面判断），最长公共前缀判定结束
                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
