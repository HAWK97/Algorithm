package com.hawk.leetCode.tree;

/**
 * 题目描述：将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树
 * 一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
 * 示例：给定有序数组: [-10,-3,0,5,9]
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class SortedArrayToBST108 {

    /**
     * 迭代
     * 解题思路：采用二分法来创建平衡二叉树，根结点刚好为数组中间的节点
     * 根节点的左子树的根是数组左边部分的中间节点，根节点的右子树的根是数据右边部分的中间节点
     */
    private TreeNode getTree(int[] nums, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = getTree(nums, left, mid - 1);
            node.right = getTree(nums, mid + 1, right);
            return node;
        }
        return null;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return getTree(nums, 0, nums.length - 1);
    }
}
