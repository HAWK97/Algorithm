package com.hawk.leetCode.array;

/**
 * 题目描述：给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列
 * 示例：略
 */
public class IncreasingTriplet334 {

    /**
     * 网上答案
     * 解题思路：维护一个二元组 (first, second)，记录第 i 个元素之前的“最小”递增二元子序列
     */
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < first) {
                first = num;
            } else if (num > first && num < second) {
                second = num;
            } else if (num > second) {
                return true;
            }
        }
        return false;
    }
}
