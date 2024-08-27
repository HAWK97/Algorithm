package com.hawk.leetCode.list;

/**
 * 题目描述：给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序
 * 示例：输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 */
public class ReverseGroup25 {

    /**
     * 解题思路：我们需要把链表节点按照 k 个一组分组，所以可以使用一个指针 head 依次指向每组的头节点，这个指针每次向前移动 k 步，直至链表结尾
     * 对于每个分组，我们先判断它的长度是否大于等于 k，若是，我们就翻转这部分链表，否则不需要翻转
     * 对于一个子链表，除了翻转其本身之外，还需要将子链表的头部与上一个子链表连接，以及子链表的尾部与下一个子链表连接
     * 因此，在翻转子链表的时候，我们不仅需要子链表头节点 head，还需要有 head 的上一个节点 pre，以便翻转完后把子链表再接回 pre
     * 我们新建一个节点，把它接到链表的头部，让它作为 pre 的初始值，这样 head 前面就有了一个节点，我们就可以避开链表头部的边界条件
     * 无论之后链表有没有翻转，它的 next 指针都会指向正确的头节点，我们只要返回它的下一个节点就好了
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
