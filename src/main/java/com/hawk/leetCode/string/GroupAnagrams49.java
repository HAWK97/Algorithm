package com.hawk.leetCode.string;

import java.util.*;

/**
 * 题目描述：给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串
 * 示例：输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class GroupAnagrams49 {

    /**
     * 网上答案
     * 解题思路：排序后字母异位词就会变成相同的单词
     * HashMap + ArrayList，对字母异位词进行分组
     * 一个 keyString 对应一个 ArrayList，归纳一组字母异位词
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String keyString = String.valueOf(chars);
            if (!map.containsKey(keyString)) {
                map.put(keyString, new ArrayList<String>());
            }
            map.get(keyString).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
