package com.hawk.leetCode.tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述：给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数
 * 示例：给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3
 */
public class MaxDepth104 {

    /**
     * 递归
     * 复杂度分析：时间复杂度 我们每个结点只访问一次，因此时间复杂度为 O(N)， 其中 N 是结点的数量
     * 空间复杂度 在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点
     * 递归将会被调用 N 次（树的高度），因此保持调用栈的存储将是 O(N)
     * 但在最好的情况下（树是完全平衡的），树的高度将是 log(N)
     * 因此，在这种情况下的空间复杂度将是 O(log(N))
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_height = maxDepth1(root.left);
        int right_height = maxDepth1(root.right);
        return Math.max(left_height, right_height) + 1;
    }

    /**
     * 迭代
     * 解题思路：从包含根结点且相应深度为 1 的栈开始，然后我们继续迭代：将当前结点弹出栈并推入子结点，每一步都会更新深度
     * 复杂度分析：时间复杂度 O(N)
     * 空间复杂度 O(N)
     */
    public int maxDepth2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair<>(root, 1));
        }
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair<>(root.left, current_depth + 1));
                stack.add(new Pair<>(root.right, current_depth + 1));
            }
        }
        return depth;
    }
}
