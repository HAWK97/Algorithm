package com.hawk.leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述：给定一个二叉树，填充它的每个 next 指针，让这个指针指向其下一个右侧节点
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL
 * 初始状态下，所有 next 指针都被设置为 NULL
 * 示例：给定完美二叉树
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * 调用你的函数后，该完美二叉树变为：
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 */
public class Connect116 {

    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    /**
     * 迭代
     */
    public void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        TreeLinkNode pre = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeLinkNode t = queue.poll();
                if (pre != null) {
                    pre.next = t;
                }
                pre = t;
                if (t.left != null) {
                    queue.offer(t.left);
                }
                if (t.right != null) {
                    queue.offer(t.right);
                }
            }
            pre.next = null;
            pre = null;
        }
    }

    /**
     * 递归
     */
    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect2(root.left);
        connect2(root.right);
    }
}
