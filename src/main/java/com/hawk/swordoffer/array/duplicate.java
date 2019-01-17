package com.hawk.swordoffer.array;

/**
 * 题目描述：在一个长度为 n 的数组里的所有数字都在 0 到 n - 1 的范围内
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次
 * 请找出数组中任意一个重复的数字
 */
public class duplicate {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length == 0 || numbers == null) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            int index = numbers[i];
            // 当 index 受到影响时，要恢复到原来的值
            if (index >= length) {
                index -= length;
            }
            if (numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] = numbers[index] + length;
        }
        return false;
    }
}
