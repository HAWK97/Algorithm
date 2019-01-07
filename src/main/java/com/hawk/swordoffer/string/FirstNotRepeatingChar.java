package com.hawk.swordoffer.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：在一个字符串中找到第一个只出现一次的字符，并返回它的位置
 * 如果没有则返回 -1
 */
public class FirstNotRepeatingChar {

    /**
     * 网上答案
     */
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
