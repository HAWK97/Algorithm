package com.hawk.swordoffer.array;

import java.util.ArrayList;

/**
 * 题目描述：输入一个递增排序的数组和一个数字 S，在数组中查找两个数，使得它们的和正好是 S
 * 如果有多对数字的和等于 S，输出两个数的乘积最小的
 */
public class FindNumbersWithSum {

    /**
     * 网上答案
     * 设置头尾两个指针，依次向中间逼近
     * 若两者之和为 sum 则返回（相距越远，乘积越小）
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length < 2) {
            return res;
        }
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                res.add(array[i]);
                res.add(array[j]);
                return res;
            } else if (array[i] + array[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}
