package com.hawk.swordoffer.tree;

import com.hawk.leetCode.tree.TreeNode;

/**
 * 题目描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向
 */
public class Convert {

    /**
     * 网上答案
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        // 将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        // 定位至左子树双链表最后一个节点
        while (p != null && p.right != null) {
            p = p.right;
        }
        // 如果左子树链表不为空的话，将当前 root 追加到左子树链表
        if (left != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        // 将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(pRootOfTree.right);
        // 如果右子树节点不为空的话，将该链表追加到 root 节点之后
        if (right != null) {
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        // 根据左子树链表是否为空确定返回的节点
        return left != null ? left : pRootOfTree;
    }
}
