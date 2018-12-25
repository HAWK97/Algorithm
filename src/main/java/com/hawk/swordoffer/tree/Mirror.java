package com.hawk.swordoffer.tree;

import com.hawk.leetCode.tree.TreeNode;

/**
 * 题目描述：操作给定的二叉树，将其变换为原二叉树的镜像
 * 示例：输入：
 *           8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9  11
 * 输出：
 *           8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7   5
 */
public class Mirror {

    private void swap(TreeNode root, TreeNode left, TreeNode right) {
        root.left = right;
        root.right = left;
    }

    /**
     * 网上答案
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        swap(root, root.left, root.right);
        Mirror(root.left);
        Mirror(root.right);
    }
}
