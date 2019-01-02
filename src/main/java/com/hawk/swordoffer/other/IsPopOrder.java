package com.hawk.swordoffer.other;

import java.util.Stack;

/**
 * 题目描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序
 * 示例：序列1, 2, 3, 4, 5是某栈的压入顺序，序列4, 5, 3, 2, 1是该压栈序列对应的一个弹出序列
 * 但4, 3, 5, 1, 2就不可能是该压栈序列对应的一个弹出序列
 */
public class IsPopOrder {

    /**
     * 网上答案
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < pushA.length;) {
            stack.push(pushA[i++]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
