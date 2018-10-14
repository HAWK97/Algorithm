package com.hawk.leetCode.string;

/**
 * 题目描述：编写一个函数，其作用是将输入的字符串反转过来
 * 示例：输入："hello" 输出: "olleh"
 */
public class ReverseString344 {

    /**
     * 我的答案
     */
    public String reverseString1(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }

    /**
     * 网上答案（StringBuilder）
     */
    public String reverseString2(String s) {
        StringBuilder ans = new StringBuilder(s);
        // 直接用reverse方法，更简单
        return ans.reverse().toString();
    }

    /**
     * 网上答案（char数组）
     */
    public String reverseString3(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        return new String(chars);
    }
}
