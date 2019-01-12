package com.hawk.swordoffer.string;

/**
 * 题目描述：对于一个给定的字符序列 S，请你把其循环左移 K 位后的序列输出
 */
public class LeftRotateString {

    /**
     * 我的答案
     */
    public String LeftRotateString(String str,int n) {
        n %= str.length();
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
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
