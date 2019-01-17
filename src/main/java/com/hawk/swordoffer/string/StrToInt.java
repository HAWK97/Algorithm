package com.hawk.swordoffer.string;

/**
 * 题目描述：将一个字符串转换成一个整数，数值为 0 或者字符串不是一个合法的数值则返回 0
 */
public class StrToInt {

    public int StrToInt(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }
        // start 用来区分第一位是否为符号位
        boolean symbol = true;
        int start = 0;
        char[] chars = str.trim().toCharArray();
        if (chars[0] == '+') {
            start = 1;
        } else if (chars[0] == '-') {
            start = 1;
            symbol = false;
        }
        int result = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return 0;
            }
            result = result * 10 + (int) (chars[i] - '0');
        }
        return symbol ? result : -result;
    }
}
