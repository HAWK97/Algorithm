package com.hawk.leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目描述：给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素
 * 示例：输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 */
public class KthSmallest230 {

    /**
     * 递归法一
     */
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    public int kthSmallest1(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }

    /**
     * 迭代
     */
    public int kthSmallest2(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int count = 0;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode t = stack.pop();
            count++;
            if (count == k) {
                return t.val;
            }
            p = t.right;
        }
        return -1;
    }

    /**
     * 分治法
     * 解题思路：由于 BST 的性质，我们可以快速定位出第 k 小的元素是在左子树还是右子树
     */
    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }

    public int kthSmallest3(TreeNode root, int k) {
        // 首先计算出左子树的结点个数 count
        int count = count(root.left);
        // 如果 k 小于等于左子树结点个数，说明第 k 小的元素在左子树中
        if (k <= count) {
            // 直接对左子树调用递归即可
            return kthSmallest3(root.left, k);
        }
        // 如果 k 大于 count + 1，说明目标值在右子树中
        else if (k > count + 1) {
            // 对右子树调用递归
            // 注意！此时的 k 应为 k - count - 1，因为已经减少了 count + 1 个结点
            return kthSmallest3(root.right, k - count - 1);
        }
        // 如果 k 正好等于 count + 1，说明当前结点即为所求，返回当前结点值即可
        return root.val;
    }
}
