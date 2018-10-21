package com.hawk.leetCode.tree;

import java.util.*;

/**
 * 题目描述：给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）
 * 示例：给定二叉树: [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrder107 {

    /**
     * 递归
     */
    private void addLevel(List<List<Integer>> list, int level, TreeNode node) {
        if (node == null) {
            return;
        }
        // 当 list 的容量比层数小时（这里把 root 看作第 0 层）
        if (list.size() - 1 < level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        addLevel(list, level + 1, node.left);
        addLevel(list, level + 1, node.right);
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        addLevel(list, 0, root);
        return list;
    }

    /**
     * 迭代
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            // 获取当前层的结点数
            int levelNum = stack.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = stack.poll();
                subList.add(node.val);
                if (node.left != null) {
                    stack.offer(node.left);
                }
                if (node.right != null) {
                    stack.offer(node.right);
                }
            }
            list.add(subList);
        }
        return list;
    }
}
