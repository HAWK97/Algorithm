package com.hawk.leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目描述：给定一个二叉树，返回它的中序遍历
 * 示例：输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 * 输出: [1,3,2]
 */
public class InorderTraversal94 {

    /**
     * 迭代
     */
    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        inOrder(root, list);
        return list;
    }

    /**
     * 遍历
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode t = stack.pop();
            list.add(t.val);
            p = t.right;
        }
        return list;
    }
}
