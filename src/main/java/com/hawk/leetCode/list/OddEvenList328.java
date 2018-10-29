package com.hawk.leetCode.list;

/**
 * 题目描述：给定一个单链表，把所有的奇数节点和偶数节点分别排在一起
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性
 * 示例：输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 */
public class OddEvenList328 {

    /**
     * 法一
     */
    public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // pre 指向奇节点，cur 指向偶节点
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.next != null) {
            ListNode tmp = pre.next;
            // 把 cur 后面的那个奇节点提前到 pre 后面
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = tmp;
            // 然后 pre 和 cur 各自前进一步
            // 此时 cur 又指向偶节点，pre 指向当前奇节点的末尾
            pre = pre.next;
            cur = cur.next;
        }
        return head;
    }

    /**
     * 法二
     */
    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // odd 指向奇节点，even 指向偶节点
        // 另外需要一个单独的指针 even_head 来保存偶节点的起点位置
        ListNode odd = head, even = head.next, even_head = head.next;
        while (even != null && even.next != null) {
            // 把奇节点的下一个指向偶节点的下一个（一定是奇结点），此奇节点后移一步
            odd.next = even.next;
            odd = odd.next;
            // 再把偶节点的下一个指向奇节点的下一个（一定是偶结点），此偶节点后移一步
            even.next = odd.next;
            even = even.next;
        }
        // 最后把分开的偶节点的链表连在奇节点的链表后即可
        odd.next = even_head;
        return head;
    }
}
