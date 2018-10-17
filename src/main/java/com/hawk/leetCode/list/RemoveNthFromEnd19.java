package com.hawk.leetCode.list;

/**
 * 题目描述：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
 * 示例：给定一个链表: 1->2->3->4->5, 和 n = 2，当删除了倒数第二个节点后，链表变为 1->2->3->5
 */
public class RemoveNthFromEnd19 {

    /**
     * 双指针解法（前指针、后指针）
     * 解题思路：让前指针先走 n 步，再让两个指针同时后移
     * 后移过程中前后指针始终相差 n 步，这样当前指针到达尾部时，后指针的下一个节点就是倒数第 n 个节点了
     * 算法复杂度：时间复杂度 O(L)，该算法对含有 L 个结点的列表进行了一次遍历，因此时间复杂度为 O(L)
     * 空间复杂度 O(1)，我们只用了常量级的额外空间
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNode = head;
        ListNode curNode = head;
        for (int i = 0; i < n; i++) {
            curNode = curNode.next;
        }
        // 当删除倒数第 length 个元素，即第一个元素时
        if (curNode == null) {
            return preNode.next;
        }
        while (curNode.next != null) {
            preNode = preNode.next;
            curNode = curNode.next;
        }
        preNode.next = preNode.next.next;
        return head;
    }
}
