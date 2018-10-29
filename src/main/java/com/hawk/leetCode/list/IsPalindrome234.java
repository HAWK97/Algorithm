package com.hawk.leetCode.list;

/**
 * 题目描述：判断一个链表是否为回文链表
 * 示例：输入: 1->2 输出：false 输入: 1->2->2->1 输出：true
 */
public class IsPalindrome234 {

    /**
     * 网上答案
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode latNode = head.next;
        ListNode preNode = head;
        // 这样循环下来，preNode 指向链表的中间位置（若中间位置有两个节点，指向左边那个）
        while (latNode != null || latNode.next != null) {
              latNode = latNode.next.next;
              preNode = preNode.next;
        }
        ListNode curNode = preNode.next;
        // 将后半段链表与前半段链表分开
        preNode.next = null;
        ListNode newHead = null;
        // 反转后半段链表
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = newHead;
            newHead = curNode;
            curNode = next;
        }
        // 将反转后的后半段链表与前半段链表进行比较
        while (head != null && newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
}
