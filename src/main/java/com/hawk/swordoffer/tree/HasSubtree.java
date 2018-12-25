package com.hawk.swordoffer.tree;

import com.hawk.leetCode.tree.TreeNode;

/**
 * 题目描述：输入两棵二叉树 A，B，判断 B 是不是 A 的子结构（约定空树不是任意一个树的子结构）
 */
public class HasSubtree {

    private boolean DoesParentHaveChild(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return DoesParentHaveChild(root1.left, root2.left) && DoesParentHaveChild(root1.right, root2.right);
    }

    /**
     * 网上答案
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;
        // 如果当前父树的节点与子树的根节点相同，则直接从父树的当前节点开始判断
        if (root1.val == root2.val) {
            result = DoesParentHaveChild(root1, root2);
        }
        if (result != true) {
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }
        return true;
    }
}
