package com.hawk.leetCode.tree;

import java.util.*;

/**
 * 题目描述：给定一个二叉树，返回其节点值的锯齿形层次遍历
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行
 * 示例：给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class ZigzagLevelOrder103 {

    /**
     * 迭代
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 0：从左向右，1：从右向左
        int flag = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> nextQueue = new LinkedList<>();
        queue.offer(root);
        List<Integer> subList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollLast();
            subList.add(node.val);
            if (flag == 0) {
                if (node.left != null) {
                    nextQueue.offer(node.left);
                }
                if (node.right != null) {
                    nextQueue.offer(node.right);
                }
            } else {
                if (node.right != null) {
                    nextQueue.offer(node.right);
                }
                if (node.left != null) {
                    nextQueue.offer(node.left);
                }
            }
            if (queue.isEmpty()) {
                Deque<TreeNode> temp = nextQueue;
                nextQueue = queue;
                queue = temp;
                flag = 1 - flag;
                list.add(subList);
                subList = new ArrayList<>();
            }
        }
        return list;
    }
}
