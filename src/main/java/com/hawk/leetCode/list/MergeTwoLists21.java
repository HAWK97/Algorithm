package com.hawk.leetCode.list;

/**
 * 题目描述：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 * 示例：输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 */
public class MergeTwoLists21 {

    /**
    * 遍历解法
    */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;
        // 不断遍历两个链表，取出小的追加到新的头节点后，直至两者其中一个为空
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        // 再将另一者追加到新链表最后
        curNode.next = (l1 != null) ? l1 : l2;
        return dummyHead.next;
    }

    /**
     * 递归解法
     * 解题思路：递归的核心方法是将问题规模不断缩小化
     * 合并两个长度为 n 和 m 的链表，当 value(n) <= value(m) 时可以将规模缩减为合并长度为 (n-1) 和 m 的链表
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
