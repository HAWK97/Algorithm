package com.hawk.leetCode.list;

/**
 * 题目描述：反转一个单链表
 * 示例：输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */
public class ReverseList206 {

    /**
     * 网上答案
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
