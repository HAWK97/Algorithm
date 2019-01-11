package com.hawk.swordoffer.other;

import java.util.ArrayList;

/**
 * 题目描述：找出所有和为 S 的连续正数序列
 */
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int plow = 1, phigh = 2;
        while (phigh > plow) {
            // 等差数列求和公式
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = plow; i <= phigh; i++) {
                    list.add(i);
                }
                result.add(list);
                plow++;
            } else if (cur < sum) {
                phigh++;
            } else {
                plow++;
            }
        }
        return result;
    }
}
