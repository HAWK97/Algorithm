package com.hawk.swordoffer.other;

/**
 * 题目描述：我们可以用 2 * 1 的小矩形横着或者竖着去覆盖更大的矩形
 * 请问用 n 个 2 * 1 的小矩形无重叠地覆盖一个 2 * n 的大矩形，总共有多少种方法
 */
public class RectCover {

    /**
     * 递归法
     * 解题思路：设被 n 个 2 * 1 的小矩形无重叠地覆盖的方法总数为 f(n)
     * 当 n = 1 时，明显 f(1) = 1
     * 当 n = 2 时，只能两个都横着放或两个都竖着放
     * 当小矩形个数为 n，第一部只有两种放法
     * 1.竖着放，那么剩下的摆放总数为 f(n - 1)
     * 2.横着放，那么剩下的摆放总数为 f(n - 2)，因为它下面的那块必须也横着放
     * 很容易看出满足斐波那契数列
     */
    public int RectCover1(int target) {
        if (target <= 1) {
            return 1;
        }
        return RectCover1(target - 1) + RectCover1(target - 2);
    }

    /**
     * 动态规划法
     * 解题思路：同上
     */
    public int RectCover2(int target) {
        if (target <= 1) {
            return 1;
        }
        int i = 1; // f(0)
        int j = 1; // f(1)
        for (; target >= 2; target--) {
            j += i;
            i = j - i; // 把相加前 j 的值赋给 i
        }
        return j;
    }
}
