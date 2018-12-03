package com.hawk.swordoffer.string;

/**
 * 题目描述：请实现一个函数，将一个字符串中的每个空格替换成 "%20"
 */
public class ReplaceSpace {

    /**
     * 我的答案
     */
    public String replaceSpace1(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

    /**
     * 网上答案
     * 解题思路：先遍历一次字符串，统计出字符串中空格的总数，并由此计算出替换之后的字符串的总长度
     * 准备两个指针 P1 和 P2，P1 指向原始字符串的末尾，而 P2 指向替换之后的字符串的末尾
     * 向前移动 P1，逐个把它指向的字符复制到 P2 指向的位置
     */
    public String replaceSpace2(StringBuffer str) {
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        int oldIndex = str.length() - 1;
        int newLength = str.length() + spaceNum * 2;
        int newIndex = newLength - 1;
        str.setLength(newLength);
        for (; oldIndex >= 0 && oldIndex < newIndex; oldIndex--) {
            if (str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            } else {
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
        }
        return str.toString();
    }
}
