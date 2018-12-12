package com.hawk.swordoffer.other;

/**
 * 题目描述：输入一个整数 n，输出斐波那契数列的第 n 项
 */
public class Fibonacci {

    /**
     * 我的答案
     */
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
