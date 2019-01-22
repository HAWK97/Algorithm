package com.hawk.swordoffer.list;

import com.hawk.leetCode.list.ListNode;

/**
 * 题目描述：删除排序链表中重复的节点，重复的节点不保留，返回链表头指针
 * 示例：输入：1->2->3->3->4->4->5
 * 输出：1->2->5
 */
public class DeleteDuplication {

    /**
     * 网上答案
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 当前节点是重复节点
        if (pHead.val == pHead.next.val) {
            ListNode pNode = pHead.next;
            // 跳过与当前节点相同的全部节点，找到第一个与当前节点不同的节点
            while (pNode != null && pNode.val == pHead.val) {
                pNode = pNode.next;
            }
            // 从第一个与当前节点不同的节点开始递归
            return deleteDuplication(pNode);
        } else {
            // 保留当前节点，从下一个节点开始递归
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
