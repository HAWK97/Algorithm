package com.hawk.leetCode.other;

/**
 * 题目描述：给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数
 * 示例：输入: [3,0,1] 输出: 2
 */
public class MissingNumber268 {

    /**
     * 网上答案
     * 解题思路：用等差数列的求和公式求出 0 到 n 之间所有的数字之和
     * 遍历数组算出给定数字的累积和，然后做减法，差值就是丢失的那个数字
     */
    public int missingNumber(int[] nums) {
        // 因为缺失了一个数，所以要加一
        // 这里的 n 指如果不缺少数字时序列的长度
        // 题目中的 n 等于 nums.length
        int n = nums.length + 1;
        int sum = n * (n - 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum = sum - nums[i];
        }
        return sum;
    }
}
