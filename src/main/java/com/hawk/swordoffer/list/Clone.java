package com.hawk.swordoffer.list;

/**
 * 题目描述：输入一个复杂链表
 * 每个节点中有节点值以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点
 * 返回结果为复制后复杂链表的 head
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Clone {

    /**
     * 网上答案（未AC）
     */
    public RandomListNode Clone(RandomListNode pHead) {
        // 第一步，复制原始链表的每个结点，并把复制出来的节点链接到原节点的后面
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode cloned = new RandomListNode(node.label);
            cloned.next = node.next;
            node.next = cloned;
            node = cloned.next;
        }
        // 第二步，设置复制出来的节点的特殊指针
        node = pHead;
        while (node != null) {
            RandomListNode cloned = node.next;
            if (node.random != null) {
                cloned.random = node.random;
            }
            node = cloned.next;
        }
        // 第三步，拆分链表，偶数位置的节点链接起来为复制链表
        // 原始链表节点
        node = pHead;
        // 复制链表头节点
        RandomListNode clonedHead = pHead.next;
        // 复制链表节点
        RandomListNode clonedNode = pHead.next;
        // 先迭代一次
        node.next = clonedNode.next;
        node = node.next;
        while (node != null) {
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
            node.next = clonedNode.next;
            node = node.next;
        }
        return clonedHead;
    }
}
