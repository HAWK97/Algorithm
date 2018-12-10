package com.hawk.swordoffer.other;

import java.util.Stack;

/**
 * 题目描述：用两个栈来实现一个队列，完成队列的 push 和 pop 操作，队列中的元素为 int 类型
 */
public class QueueWithTwoStacks {

    Stack<Integer> stack1 = new Stack<Integer>();

    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 网上答案
     * 解题思路：push 时将数据压入 stack1
     * pop 时将 stack1 中所有数据弹出到 stack2
     * 再将 stack2 中第 1 个数弹出作为返回值
     * 最后将 stack2 中所有数据弹出到 stack1
     */
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int node = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return node;
    }
}
