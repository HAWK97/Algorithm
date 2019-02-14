package com.hawk.leetCode.array;

/**
 * 题目描述：你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额
 * 示例：输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)
 * 偷窃到的最高金额 = 1 + 3 = 4
 */
public class Rob198 {

    /**
     * 动态规划法一
     * 维护一个一维数组 dp，其中 dp[i] 表示到 i 位置时不相邻数能形成的最大和
     * 经推导得状态转移方程 dp[i] = max(nums[i] + dp[i - 2], dp[i - 1])
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        // 初始化dp[0] = nums[0]，dp[1] = max(nums[0], nums[1])
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    /**
     * 动态规划法二（有点没看懂）
     * 分别维护两个变量 a 和 b，然后按奇偶分别来更新 a 和 b，这样就可以保证组成最大和的数字不相邻
     */
    public int rob2(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                a = Math.max(a + nums[i], b);
            } else {
                b = Math.max(a, b + nums[i]);
            }
        }
        return Math.max(a, b);
    }
}
