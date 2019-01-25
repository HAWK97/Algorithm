package com.hawk.swordoffer.tree;

import com.hawk.leetCode.tree.TreeNode;

/**
 * 题目描述：请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Serialize {

    /**
     * 网上答案
     */
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    private int index = -1;

    TreeNode Deserialize(String str) {
        index++;
        String[] strs = str.split(",");
        TreeNode node = null;
        if (!strs[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
