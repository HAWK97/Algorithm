package com.hawk.leetCode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述：给定一个链表，判断链表中是否有环
 */
public class HasCycle141 {

    /**
     * 哈希表
     * 解题思路：我们可以通过检查一个结点此前是否被访问过来判断链表是否为环形链表，常用的方法是使用哈希表
     * 我们遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）
     * 如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）
     * 算法复杂度：时间复杂度 O(n)，对于含有 n 个元素的链表，我们访问每个元素最多一次。添加一个结点到哈希表中只需要花费 O(1) 的时间
     * 空间复杂度 O(n)， 空间取决于添加到哈希表中的元素数目，最多可以添加 n 个元素
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 双指针
     * 解题思路：通过使用具有不同速度的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)
     * 慢指针每次移动一步，而快指针每次移动两步
     * 如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false
     * 如果存在环，快、慢指针最终会相遇
     * 算法复杂度：时间复杂度 O(n)， 让我们将 n 设为链表中结点的总数
     * 空间复杂度 O(1)， 我们只使用了慢指针和快指针两个结点，所以空间复杂度为 O(1)
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
