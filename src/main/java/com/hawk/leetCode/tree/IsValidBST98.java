package com.hawk.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

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
     * 递归法
     * BST 的要求不只是左节点小于根节点小于右节点
     * 还有个隐含的条件是左子树里所有节点都要小于根节点，而右子树里所有节点都要大于根节点
     * 要把这个上限和下限代入递归中
     */
    private boolean isValidBST1(TreeNode root, int max, int min) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        // 左子树的最大值为根节点，无最小值
        // 而右子树的最小值为根节点，无最大值
        return isValidBST1(root.left, root.val, min) && isValidBST1(root.right, max, root.val);
    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST1(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    /**
     * 中序遍历（递归)
     * 通过中序遍历将所有的节点值存到一个数组里，然后再来判断这个数组是不是有序的
     */
    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
