package com.hawk.leetCode.other;

import java.util.Stack;

/**
 * 题目描述：设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈
 * push(x) -- 将元素 x 推入栈中
 * pop() -- 删除栈顶的元素
 * top() -- 获取栈顶元素
 * getMin() -- 检索栈中的最小元素
 * 示例：MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3
 * minStack.pop();
 * minStack.top();      --> 返回 0
 * minStack.getMin();   --> 返回 -2
 */
public class MinStack155 {

    /**
     * 法一
     * 解题思路：使用两个栈来实现，一个栈按顺序存储 push 进来的数据，另一个用来存出现过的最小值
     */
    private Stack<Integer> stack1 = new Stack<>();

    private Stack<Integer> stack2 = new Stack<>();

    public MinStack155() {

    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
    }

    public void pop() {
        int x = stack1.pop();
        if (stack2.peek() == x) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

    /**
     * 法二
     */
//    private int min_val = Integer.MAX_VALUE;
//
//    private Stack<Integer> stack = new Stack<>();
//
//    public MinStack() {
//
//    }
//
//    public void push(int x) {
//        // 在当前最小值更改时，把当前最小值和新进来的数一起入栈，min_val变为这个新进来的数
//        if (x <= min_val) {
//            stack.push(min_val);
//            min_val = x;
//        }
//        stack.push(x);
//    }
//
//    public void pop() {
//        // 如果栈顶元素的值和 min_val 相等，那么它的下一个元素就是之前的最小值
//        // 将之前的最小值赋给 min_val，并把它弹出（因为它属于重复入栈）
//        if (stack.pop() == min_val) {
//            min_val = stack.pop();
//        }
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return min_val;
//    }
}
