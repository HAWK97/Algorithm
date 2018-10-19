package com.hawk.leetCode.array;

/**
 * 题目描述：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）
 * 示例：输入: [7,1,5,3,6,4] 输出: 7
 * 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3
 */
public class MaxProfit122 {

    /**
     * 峰谷法
     * 解题思路：将股票价格变化曲线用图像（图像是重点！）表示出来，可以看到最大利润是所有峰谷差值的和
     * 复杂度分析：时间复杂度 O(n)，对数组遍历一次
     * 空间复杂度 O(1)，需要恒定空间
     */
    public int maxProfit1(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            // 确定谷底值
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            // 确定峰值
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    /**
     * 简单法
     * 解题思路：通过观察图像，我们可以直接得出最大利润是所有相邻元素增加值之和
     * 复杂度分析：时间复杂度 O(n)，对数组遍历一次
     * 空间复杂度 O(1)，需要恒定空间
     */
    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
