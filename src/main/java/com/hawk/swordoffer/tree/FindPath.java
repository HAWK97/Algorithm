package com.hawk.swordoffer.tree;

import com.hawk.leetCode.tree.TreeNode;

import java.util.ArrayList;

/**
 * 题目描述：输入一棵二叉树的根节点和一个整数
 * 打印出二叉树中节点值的和为输入整数的所有路径
 * 路径定义为从树的根节点开始往下一直到叶结点所经过的节点形成一条路径
 * 注意: 在返回值的 list 中，数组长度大的靠前
 */
public class FindPath {

    /**
     * 网上答案
     */
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            // add 添加的是引用，如果不 new 一个的话，后面的操作会更改 list
            result.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 深度遍历完一条路径后移除最后一个元素
        list.remove(list.size() - 1);
        return result;
    }
}
