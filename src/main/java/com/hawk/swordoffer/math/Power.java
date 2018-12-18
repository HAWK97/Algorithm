package com.hawk.swordoffer.math;

/**
 * 题目描述：给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方
 */
public class Power {

    /**
     * 我的答案
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = base;
        if (exponent < 0) {
            exponent = -exponent;
            for (int i = 2; i <= exponent; i++) {
                result *= base;
            }
            return 1 / result;
        }
        for (int i = 2; i <= exponent; i++) {
            result *= base;
        }
        return result;
    }
}
