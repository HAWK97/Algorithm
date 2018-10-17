package com.hawk.leetCode.list;

/**
 * 题目描述：请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点
 * 示例：输入: head = [4,5,1,9], node = 5 输出：[4,1,9] 输入: head = [4,5,1,9], node = 1 输出：[4,5,9]
 */
public class DeleteNode237 {

    /**
     * 网上答案
     * 解题思路：单链表无法回溯，因此可以删除给定结点的下一个节点，并将下一个节点的值赋给给定节点，这样也可以算作删除了给定节点
     */
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        ListNode next = node.next;
        node.next = next.next;
        node.val = next.val;
    }
}
