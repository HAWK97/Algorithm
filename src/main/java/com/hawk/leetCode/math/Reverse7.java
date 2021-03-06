package com.hawk.leetCode.math;

/**
 * 题目描述：给定一个 32 位有符号整数，将整数中的数字进行反转
 * 示例：输入：123 输出：321
 */
public class Reverse7 {

    /**
     * 弹出和推入数字 & 溢出前进行检查
     * 解题思路：我们可以一次构建反转整数的一位数字
     * 在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出
     * 复杂度分析：时间复杂度 O(log n)，x 中大约有 O(log n) 位数字
     * 空间复杂度 O(1)
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 备注：Integer.MAX_VALUE 的值为 2^31 - 1，Integer.MIN_VALUE 的值为 -2^31
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
