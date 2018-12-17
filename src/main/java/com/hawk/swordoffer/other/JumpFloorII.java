package com.hawk.swordoffer.other;

/**
 * 题目描述：一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级......它也可以跳上 n 级，求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 */
public class JumpFloorII {

    /**
     * 递归法一
     */
    public int JumpFloorII1(int target) {
        // 跳上一个 1 级的台阶只有 1 种跳法
        if (target == 1) {
            return 1;
        }
        // 这里的 1 指一次跳上 n 级台阶
        int sum = 1;
        for (int i = 2; i <= target; i++) {
            sum += JumpFloorII1(i - 1);
        }
        return sum;
    }

    /**
     * 递归法二
     * 解题思路：用 f(n) 表示 n 级台阶的总共跳法
     * 若第一次跳 1 级，剩下 n - 1 级未跳，剩下的跳法是 f(n - 1)
     * 若第一次跳 2 级，剩下 n - 2 级未跳，剩下的跳法是 f(n - 2)，以此类推
     * 可得 f(n) = f(n - 1) + f(n - 2) + ... + f(1)
     * f(n -1) = f(n - 2) + f(n - 3) + ... + f(1)
     * 两式相减得 f(n) = 2 * f(n - 1)
     */
    public int JumpFloorII2(int target) {
        if (target == 1) {
            return 1;
        }
        return 2 * JumpFloorII2(target - 1);
    }

    /**
     * 最短解法
     * 解题思路：由 f(n) = 2 * f(n - 1)
     * 可得 f(n - 1) = 2 * f(n - 2)，f(n - 2) = 2 * f(n - 3) ... f(2) = 2 * f(1)
     * 最终可得 f(n) = 2 ^ (n - 1)
     */
    public int JumpFloorII3(int target) {
        return 1 << (target - 1);
    }
}
