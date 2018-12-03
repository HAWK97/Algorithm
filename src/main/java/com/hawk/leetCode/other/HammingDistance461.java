package com.hawk.leetCode.other;

/**
 * 题目简介：两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目
 * 给出两个整数 x 和 y，计算它们之间的汉明距离
 * 示例：输入: x = 1, y = 4 输出：2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置
 */
public class HammingDistance461 {

    /**
     * 我的答案
     */
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += num & 1;
            num = num >> 1;
        }
        return result;
    }
}
