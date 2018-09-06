package com.hawk.leetCode.list;

/**
 * 题目描述：给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表
 * 示例：输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 */
public class AddTwoNumbers2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 解题思路：使用变量 carry 来表示进位，进位 carry 必定是 0（不进位）或 1（进1位）
     * 算法复杂度：时间复杂度 O(max(m,n))，假设 m 和 n 分别表示 l1 和 l2 的长度，上面的算法最多重复 max(m,n) 次
     * 空间复杂度 O(max(m,n))， 新列表的长度最多为 max(m,n)+1
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 哑结点，即链表的第一个节点，起指示作用，无其他意义
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        // p、q 都为null时跳出循环
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        // 如l1=[9,9] l2=[1]，求和运算最后可能出现额外的进位，因此要在最后再检查一次进位
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
