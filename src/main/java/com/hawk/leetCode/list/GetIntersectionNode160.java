package com.hawk.leetCode.list;

/**
 * 题目描述：编写一个程序，找到两个单链表相交的起始节点
 * 示例：例如，下面的两个链表
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * 在节点 c1 开始相交
 */
public class GetIntersectionNode160 {

    /**
     * 我的答案（参考网上）
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA, b = headB;
        int lenA = 0, lenB = 0;
        while (a != null) {
            a = a.next;
            lenA++;
        }
        while (b != null) {
            b = b.next;
            lenB++;
        }
        a = headA;
        b = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                b = b.next;
            }
        }
        while (a != null && b != null) {
            if (a.val == b.val) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}
