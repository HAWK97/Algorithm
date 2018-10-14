package com.hawk.leetCode.array;

/**
 * 题目描述：给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字
 * 示例：输入：[1,2,3] 输出：[1,2,4]
 */
public class PlusOne66 {

    /**
     * 我的答案
     */
    public int[] plusOne1(int[] digits) {
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1] += 1;
            }
        }
        if (digits[0] == 10) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            newDigits[1] = 0;
            for (int i = 1; i < digits.length; i++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        }
        return digits;
    }

    /**
     * 网上答案
     */
    public int[] plusOne2(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry == 0) {
                return digits;
            }
            int tmp = digits[i] + carry;
            carry = tmp / 10;
            digits[i] = tmp % 10;
         }
         if (carry != 0) {
             int[] newDigits = new int[digits.length + 1];
             // 如果产生新数组，必定是1000...的形式（这点没想到）
             newDigits[0] = 1;
             return newDigits;
         }
         return digits;
    }
}
