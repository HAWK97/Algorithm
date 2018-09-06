package com.hawk.leetCode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 题目描述：给定一个字符串，找出不含有重复字符的最长子串的长度
 * 示例：给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是 3
 */
public class LengthOfLongestSubstring3 {

    /**
     * 滑动窗口
     * 解题思路：我们使用 HashSet 将字符存储在当前窗口 [i, j)（最初 j = i）中
     * 然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。直到 s[j] 已经存在于 HashSet 中
     * 此时，我们找到的没有重复字符的最长子字符串将会以索引 i 开头
     * 当找到一个没有重复字符的子字符串后，我们向右滑动 i，重复上述操作
     * 算法复杂度：时间复杂度 O(2n)=O(n)，在最糟糕的情况下，每个字符将被 i 和 j 访问两次
     * 空间复杂度 O(min(m, n))，滑动窗口法需要 O(k) 的空间，其中 k 表示 Set 的大小
     * 而 Set 的大小取决于字符串 n 的大小以及字符集/字母 m 的大小
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                // 首先执行 set.add(s.charAt(j))，再 j++
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 优化的滑动窗口
     * 我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。当我们找到重复的字符时，我们可以立即跳过该窗口
     * 也就是说，如果在 [i, j) 范围内存在 s[j′] 与 s[j] 相等，我们不需要逐渐增加 i
     * 可以直接跳过 [i，j′] 范围内的所有元素，并将 i 变为 j' + 1
     * 算法复杂度：时间复杂度 O(n)，索引 j 将会迭代 n 次
     * 空间复杂度 O(min(m,n))，与之前的方法相同
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                // 这里为什么要用 Math.max()
                // 可以尝试分析 "abba"
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }
}
