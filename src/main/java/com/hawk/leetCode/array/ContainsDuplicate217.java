package com.hawk.leetCode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述：给定一个整数数组，判断是否存在重复元素
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false
 * 示例：输入: [1,2,3,1] 输出: true
 */
public class ContainsDuplicate217 {

    /**
     * 我的答案
     * 知识点：对于自平衡二叉搜索树（Java 中的 TreeSet 或 TreeMap），搜索和插入的时间复杂度为 O(log n)
     * 对于哈希表（Java 中的 HashSet 或 HashMap），搜索和插入的时间复杂度为 O(1)
     * 复杂度分析：时间复杂度 O(n)，搜索和插入的次数为 n，每个操作的时间复杂度为 O(1)
     * 空间复杂度 O(n)，哈希表使用的空间与其中的元素数量成线性关系
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
