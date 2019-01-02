package com.hawk.swordoffer.tree;

/**
 * 题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树后序遍历的结果
 */
public class VerifySquenceOfBST {

    private boolean judge(int[] sequence, int l, int r) {
        if (l >= r) {
            return true;
        }
        int root = sequence[r];
        int i = 0;
        for (; i < r; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j < r; j++) {
            // 在右子树中找到小于根节点的节点直接返回 false
            if (sequence[j] < root) {
                return false;
            }
        }
        return judge(sequence, l, i - 1) && judge(sequence, i, r - 1);
    }

    /**
     * 网上答案
     * 解题思路：序列最后一个元素为二叉搜索树的根节点
     * 去掉最后一个元素的序列的前一段（左子树）小于根节点，后一段（右子树）大于根节点
     * 且这两段（子树）都是合法的后序序列
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return judge(sequence, 0, sequence.length - 1);
    }
}
