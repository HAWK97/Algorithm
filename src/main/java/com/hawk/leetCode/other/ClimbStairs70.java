package com.hawk.leetCode.other;

/**
 * 题目示例：假设你正在爬楼梯。需要 n 阶你才能到达楼顶
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢
 * 示例：输入：3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class ClimbStairs70 {

    /**
     * 法一
     * 解题思路：假设楼梯有 n 层，那么如何爬到第 n 层呢
     * 因为每次只能爬 1 或 2 步，那么爬到第 n 层的方法要么是从第 n - 1 层 1 步上来的，要不就是从 n - 2 层 2 步上来的
     * 所以递推公式非常容易的就得出了：dp[n] = dp[n-1] + dp[n-2]
     */
    public int climbStairs1(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n];
        // 爬到第一层有一种方法，爬到第二层有两种方法
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * 法二
     * 解题思路：只用两个整型变量 a 和 b 来存储过程值
     * 首先将 a + b 的值赋给 b，然后将 a 赋值为原来的 b，即现在的 b - a
     * 这样就模拟了上面累加的过程，而不用存储所有的值
     *
     */
    public int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }
        int a = 1, b = 1;
        for (int i = 1; i < n; i++) {
            b = a + b;
            a = b - a;
        }
        return b;
    }
}
