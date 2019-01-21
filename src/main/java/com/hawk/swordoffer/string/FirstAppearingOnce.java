package com.hawk.swordoffer.string;

/**
 * 题目描述：请实现一个函数用来找出字符流中第一个只出现一次的字符
 */
public class FirstAppearingOnce {

    int[] hashtable = new int[256];

    StringBuffer s = new StringBuffer();

    /**
     * 网上答案
     */
    public void Insert(char ch) {
        s.append(ch);
        if (hashtable[ch] == 0) {
            hashtable[ch] = 1;
        } else {
            hashtable[ch] += 1;
        }
    }

    public char FirstAppearingOnce() {
        char[] chars = s.toString().toCharArray();
        for (char c : chars) {
            if (hashtable[c] == 1) {
                return c;
            }
        }
        return '#';
    }
}
