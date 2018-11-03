package com.hawk.leetCode.tree;

import com.hawk.dataStructure.stack.Stack;

/**
 * 题目描述：给定一个二叉树，检查它是否是镜像对称的
 * 示例：二叉树 [1,2,2,3,4,4,3] 是对称的
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 */
public class IsSymmetric101 {

    /**
     * 递归
     * 解题思路：首先判断根节点是否存在，若存在则比较他们的值是否相等
     * 若相等则继续比较树 1 的左子树和树 2 的右子树是否互为镜像，同时也比较树 1 的右子树和树 2 的左子树是否互为镜像
     */
    private boolean isSymmetric1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetric1(root1.left, root2.right) && isSymmetric1(root1.right, root2.left);
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
        return true;
    }
        return isSymmetric1(root.left, root.right);
}

    /**
     * 迭代
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root.left;
        TreeNode q = root.right;
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()) {
            p = stack.pop();
            q = stack.pop();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            stack.push(p.left);
            stack.push(q.right);
            stack.push(p.right);
            stack.push(q.left);
        }
        return true;
    }
}
