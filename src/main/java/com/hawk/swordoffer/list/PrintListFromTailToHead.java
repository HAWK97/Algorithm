package com.hawk.swordoffer.list;

import com.hawk.leetCode.list.ListNode;

import java.util.ArrayList;

/**
 * 题目描述：输入一个链表，按链表值从尾到头的顺序返回一个 ArrayList
 */
public class PrintListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode head = listNode;
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (newHead != null) {
            list.add(newHead.val);
            newHead = newHead.next;
        }
        return list;
    }
}
