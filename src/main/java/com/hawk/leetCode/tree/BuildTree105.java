package com.hawk.leetCode.tree;

/**
 * 题目描述：根据一棵树的前序遍历与中序遍历构造二叉树
 * 示例：例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree105 {

    /**
     * 网上答案
     */
    private TreeNode buildCore(int[] preorder, int preFirst, int preEnd, int[] inorder, int inFirst, int inEnd) {
        // 前序遍历第一个节点是根节点
        int rootValue = preorder[preFirst];
        TreeNode root = new TreeNode(rootValue);
        // 前序序列只有根节点
        if (preFirst == preEnd) {
            return root;
        }
        // 遍历中序序列，找到根节点的位置
        int rootInorder = inFirst;
        while (inorder[rootInorder] != rootValue && rootInorder <= inEnd) {
            rootInorder++;
        }
        // 左子树的长度
        int leftLength = rootInorder - inFirst;
        // 前序序列中左子树的最后一个节点
        int leftPreEnd = preFirst + leftLength;
        // 左子树非空
        if (leftLength > 0) {
            // 重建左子树
            root.left = buildCore(preorder, preFirst + 1, leftPreEnd, inorder, inFirst, rootInorder - 1);
        }
        // 右子树非空
        if (leftLength < preEnd - preFirst) {
            // 重建右子树
            root.right = buildCore(preorder, leftPreEnd + 1, preEnd, inorder, rootInorder + 1, inEnd);
        }
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }
        return buildCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}
