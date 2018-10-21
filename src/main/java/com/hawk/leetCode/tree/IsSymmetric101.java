package com.hawk.leetCode.tree;

import java.util.ArrayDeque;
import java.util.Queue;

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
     * 未通过！
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();
        if (root.left != null) {
            q1.offer(root.left);
        }
        if (root.right != null) {
            q2.offer(root.right);
        }
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
                return false;
            }
            if (node1 != null) {
                if (node1.val != node2.val) {
                    return false;
                }
                if (node1.left != null) {
                    q1.offer(node1.left);
                }
                if (node1.right != null) {
                    q1.offer(node1.right);
                }
                if (node2.right != null) {
                    q2.offer(node2.right);
                }
                if (node2.left != null) {
                    q2.offer(node2.left);
                }
            }
        }
        return true;
    }
}
