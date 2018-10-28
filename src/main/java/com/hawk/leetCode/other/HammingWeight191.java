package com.hawk.leetCode.other;

/**
 * 题目描述：编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）
 * 示例：输入：11 输出：3
 * 解释: 整数 11 的二进制表示为 00000000000000000000000000001011
 */
public class HammingWeight191 {

    /**
     * 网上答案
     */
    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // 判断最后一位是否与1相等，若相等就将 result + 1
            result += n & 1;
            // 将原数字右移一位
            n = n >> 1;
        }
        return result;
    }
}
