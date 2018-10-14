package com.hawk.leetCode.string;

public class reverseString {

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
     * 网上答案
     */
    public String reverseString2(String s) {
        StringBuilder ans = new StringBuilder(s);
        // 直接用reverse方法，更简单
        return ans.reverse().toString();
    }
}
