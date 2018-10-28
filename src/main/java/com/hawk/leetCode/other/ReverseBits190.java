package com.hawk.leetCode.other;

/**
 * 题目描述：颠倒给定的 32 位无符号整数的二进制位
 * 示例：输入: 43261596 输出：输出: 964176192
 * 解释: 43261596 的二进制表示形式为 00000010100101000001111010011100
 * 返回 964176192，其二进制表示形式为 00111001011110000010100101000000
 */
public class ReverseBits190 {

    /**
     * 我的答案
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                result += 1 << (31 - i);
            }
            n = n >> 1;
        }
        return result;
    }
}
