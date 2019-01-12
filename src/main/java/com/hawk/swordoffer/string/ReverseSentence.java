package com.hawk.swordoffer.string;

/**
 * 题目描述：翻转单词顺序
 * 示例：输入：student. a am I
 * 输出：I am a student.
 */
public class ReverseSentence {

    /**
     * 网上答案
     */
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        // 先翻转整个句子
        reverse(chars, 0, chars.length - 1);
        // 然后依次翻转每个单词
        int blank = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                int nextBlank = i;
                reverse(chars, blank + 1, nextBlank - 1);
                blank = nextBlank;
            }
        }
        // 单独翻转最后一个单词
        reverse(chars, blank + 1, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        char temp;
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
