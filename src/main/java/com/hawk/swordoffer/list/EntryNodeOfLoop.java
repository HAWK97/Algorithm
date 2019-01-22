package com.hawk.swordoffer.list;

import com.hawk.leetCode.list.ListNode;

/**
 * 题目描述：给定一个链表，若其中包含环，请找出该链表的环的入口节点
 * 否则，输出 null
 */
public class EntryNodeOfLoop {

    /**
     * 网上答案：第一步，找环中相汇点
     * 第二步，找环的入口
     * 快慢指针相汇时，慢指针实际走了一个环的步数
     * 让快指针指向链表头部，慢指针位置不变（此时慢指针比快指针多走一个环的步数）
     * 两个指针以相同的速度向前移动
     * 当快指针指向环的入口节点时，慢指针已经围绕着环走了一圈回到了入口节点
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = pHead;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;

            }
        }
        return null;
    }
}
