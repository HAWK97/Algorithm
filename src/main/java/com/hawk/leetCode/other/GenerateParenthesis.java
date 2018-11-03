package com.hawk.leetCode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合
 * 示例：例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParenthesis {

    /**
     * 递归法
     */
    private void helper(int left, int right, String out, List<String> list) {
        // 定义两个变量 left 和 right 分别表示剩余左右括号的个数
        // 如果在某次递归时，左括号的剩余个数大于右括号的剩余个数
        // 说明此时生成的字符串中右括号的个数大于左括号的个数，即会出现 ")(" 这样的非法串，所以这种情况直接返回
        if (left < 0 || right > 0 || left  >right) {
            return;
        }
        if (left == 0 && right == 0) {
            list.add(out);
            return;
        }
        helper(left - 1, right, out + "(", list);
        helper(left, right - 1, out + ")", list);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        helper(n, n, "", list);
        return list;
    }
}
