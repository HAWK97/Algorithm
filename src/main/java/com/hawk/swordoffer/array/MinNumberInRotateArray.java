package com.hawk.swordoffer.array;

/**
 * 题目描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素
 * 实例：数组 {3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，该数组的最小值为 1
 */
public class MinNumberInRotateArray {

    /**
     * 我的答案
     */
    public int minNumberInRotateArray(int [] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return array[i];
            }
        }
        return array[0];
    }
}
