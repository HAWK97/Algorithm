package com.hawk.swordoffer.tree;

import com.hawk.leetCode.tree.TreeNode;

/**
 * 题目描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树
 */
public class IsBalanced {

    /**
     * 网上答案 1
     * 遍历每个结点，根据该节点的左右子树高度差判断是否平衡
     * 然后递归地对左右子树进行判断
     */
    public boolean IsBalanced_Solution1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && IsBalanced_Solution1(root.left) && IsBalanced_Solution1(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 网上答案 2
     * 答案 1 有明显的问题，在判断上层结点的时候，会多次重复遍历下层节点
     * 如果改为从下往上遍历，如果子树是平衡二叉树，则返回子树的高度
     * 如果发现子树不是平衡二叉树，则直接停止遍历
     */
    public boolean IsBalanced_Solution2(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right);
    }
}
