package com.hawk.leetCode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合
 * 给出数字到字母的映射如下（与电话按键相同）
 * 2:abc 3:def 4:ghi 5:jkl 6:mno 7:pqrs 8:tuv 9:wxyz
 * 示例：输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
public class  LetterCombinations17 {

    /**
     * 递归法
     */
    private void letterCombinationsDFS(String digits, String[] dict, int level, StringBuilder out, List<String> list) {
        // level 记录当前生成的字符串的字符个数
        if (level == digits.length()) {
            list.add(out.toString());
        }
        else {
            // 因为输入的数字从 2 开始，所以要减去 2
            String str = dict[digits.charAt(level) - '2'];
            for (int i = 0; i < str.length(); i++) {
                out.append(str.charAt(i));
                letterCombinationsDFS(digits, dict, level + 1, out, list);
                out.deleteCharAt(out.length() - 1);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }
        String[] dict = {"abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        letterCombinationsDFS(digits, dict, 0, new StringBuilder(), list);
        return list;
    }
}
