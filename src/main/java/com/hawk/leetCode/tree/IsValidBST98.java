package com.hawk.leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目描述：给定一个二叉树，判断其是否是一个有效的二叉搜索树
 * 示例：输入：
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出：false
 */
public class IsValidBST98 {

    /**
     * 递归
     * 解题思路：BST 的要求不只是左节点小于根节点小于右节点
     * 还有个隐含的条件是左子树里所有节点都要小于根节点，而右子树里所有节点都要大于根节点
     * 要把这个上限和下限代入递归中
     */
    private boolean valid(TreeNode root, int max, int min) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        // 左子树的最大值为根节点，无最小值
        // 而右子树的最小值为根节点，无最大值
        return valid(root.left, root.val, min) && valid(root.right, max, root.val);
    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return valid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    /**
     * 中序遍历（递归法一)
     * 解题思路：通过中序遍历将所有的节点值存到一个数组里，然后再来判断这个数组是不是有序的
     */
    private void inOrder1(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder1(node.left, list);
        list.add(node.val);
        inOrder1(node.right, list);
    }

    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder1(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历（递归法二）
     * 解题思路：与递归法一不同之处是不将遍历结果存入一个数组遍历完成再比较
     * 而是每当遍历到一个新节点时和其上一个节点比较，如果不大于上一个节点那么则返回 false，全部遍历完成后返回 true
     */
    private TreeNode pre;

    private Integer result;

    private void inOrder2(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder2(node.left);
        if (pre != null) {
            if (node.val <= pre.val) {
                result = 0;
            }
        }
        pre = node;
        inOrder2(node.right);
    }

    public boolean isValidBST3(TreeNode root) {
        pre = null;
        result = 1;
        inOrder2(root);
        return result == 1;
    }

    /**
     * 中序遍历（迭代）
     */
    public boolean isValidBST4(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        // p != null 不可少！
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode t = stack.pop();
            if (pre != null && t.val <= pre.val) {
                return false;
            }
            pre = t;
            p = t.right;
        }
        return true;
    }
}
