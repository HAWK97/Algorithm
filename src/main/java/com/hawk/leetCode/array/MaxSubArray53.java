package com.hawk.leetCode.array;

/**
 * 题目描述：给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * 示例：输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 */
public class MaxSubArray53 {

    /**
     * 动态规划
     */
    public int maxSubArray1(int[] nums) {
        int sum = 0, ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 如果前面数字的和小 0，那么当前数字加上前面的和就一定比自身小
            // 所以从当前数字开始重新求和
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
