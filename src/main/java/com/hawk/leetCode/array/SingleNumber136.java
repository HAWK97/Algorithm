package com.hawk.leetCode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 * 示例：输入: [2,2,1] 输出: 1
 */
public class SingleNumber136 {

    /**
     * 我的答案（先排序）
     * 解题思路、算法复杂度：略
     */
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
            i += 2;
        }
        return nums[nums.length - 1];
    }

    /**
     * 我的答案（使用哈希表）
     * 解题思路、算法复杂度：略
     */
    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }
        return set.iterator().next();
    }
}
