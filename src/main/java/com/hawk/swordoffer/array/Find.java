package com.hawk.swordoffer.array;

/**
 * 题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class Find {

    /**
     * 网上答案
     * 解题思路：首先选取数组右上角的数字，如果该数字等于要查找的数字，查找过程结束
     * 如果该数字大于要查找的数字，剔除这个数字所在的列
     * 如果该数字小于要查找的数字，剔除这个数字所在的行
     * 也就是说如果查找的数字不在数组的右上角，则每次都在数组的查找范围中剔除一行或者一列
     */
    public boolean Find(int target, int [][] array) {
        boolean isFind = false;

        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (array[row][col] == target) {
                isFind = true;
                break;
            } else if (array[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return isFind;
    }
}
