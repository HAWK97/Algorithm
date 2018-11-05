package com.hawk.leetCode.math;

/**
 * 题目描述：给定一个整数，写一个函数来判断它是否是 3 的幂次方
 * 示例：输入：27 输出：true
 */
public class IsPowerOfThree326 {

    /**
     * 我的答案（递归）
     */
    public boolean isPowerOfThree1(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 3 == 0 && n != 0) {
            return isPowerOfThree1(n / 3);
        }
        return false;
    }

    /**
     * 网上答案（循环）
     */
    public boolean isPowerOfThree2(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
