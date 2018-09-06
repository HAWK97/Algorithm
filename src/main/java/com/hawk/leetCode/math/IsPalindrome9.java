package com.hawk.leetCode.math;

/**
 * 题目描述：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * 示例：输入：121 输出：true
 */
public class IsPalindrome9 {

    /**
     * 反转一半数字
     * 解题思路：只反转 int 数字的一半，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同
     * 例如，输入 1221，我们可以将数字 “1221” 的后半部分从 “21” 反转为 “12”，并将其与前半部分 “12” 进行比较
     * 因为二者相同，我们得知数字 1221 是回文
     * 复杂度分析：时间复杂度 O(log(n))，对于每次迭代，我们会将输入除以 10，因此时间复杂度为 O(log(n))
     * 空间复杂度 O(1)
     */
    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }
}
