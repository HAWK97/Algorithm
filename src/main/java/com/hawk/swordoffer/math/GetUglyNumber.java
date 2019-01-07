package com.hawk.swordoffer.math;

/**
 * 题目描述：把只包含质因子 2、3 和 5 的数称作丑数
 * 习惯上我们把 1 当做是第一个丑数，求按从小到大的顺序的第 N 个丑数
 * 示例：例如 6、8 都是丑数，但 14 不是，因为它包含质因子 7
 */
public class GetUglyNumber {

    /**
     * 网上答案
     */
    public int GetUglyNumber_Solution(int index) {
        // 1 2 3 4 5 6 都是丑数，所以小于 7 时直接返回
        if (index < 7) {
            return index;
        }
        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, i;
        for (i = 1; i < index; i++) {
            res[i] = Math.min(res[t2] * 2, Math.min(res[t3] * 3, res[t5] * 5));
            if (res[i] == res[t2] * 2) {
                t2++;
            }
            if (res[i] == res[t3] * 3) {
                t3++;
            }
            if (res[i] == res[t5] * 5) {
                t5++;
            }
        }
        return res[index - 1];
    }
}
