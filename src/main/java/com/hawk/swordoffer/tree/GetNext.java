package com.hawk.swordoffer.tree;

class TreeLinkNode {

    int val;

    TreeLinkNode left = null;

    TreeLinkNode right = null;

    // 这里的 next 指向该节点的父结点
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

/**
 * 题目描述：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回
 */
public class GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 如果有右子树，则找右子树的最左结点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        // 没有右子树时，如果该结点是其父结点的左孩子，则返回父结点
        // 否则继续向上遍历其父结点的父结点，重复之前的判断
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
