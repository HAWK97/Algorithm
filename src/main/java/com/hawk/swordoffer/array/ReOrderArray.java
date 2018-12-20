package com.hawk.swordoffer.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
 */
public class ReOrderArray {

    /**
     * 开辟额外数组
     * 解题思路：把奇数和偶数按顺序挑出来分别放到 List 里，最后再把偶数 List 接到奇数 List 的末尾
     */
    public void reOrderArray1(int[] array) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                even.add(array[i]);
            } else {
                odd.add(array[i]);
            }
        }
        odd.addAll(even);
        for (int i = 0; i < array.length; i++) {
            array[i] = odd.get(i);
        }
    }

    /**
     * 不开辟额外数组
     * 解题思路：从数组的第一个位置往后依次遍历，遇到第一个偶数暂停，此时下标位置记为 i
     * 然后从位置 i + 1 开始，依次往后遍历，直到遇到第一个奇数，此时下标记为 j
     * 将数组第 i 个位置到第 j - 1 个位置依次往后挪一位
     * 最后将挪动前 j 位置的值赋给第 i 个位置，然后执行 i++，以此类推
     */
    public void reOrderArray2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] % 2 != 0) {
                        int temp = array[j];
                        for (int k = j; k > i; k--) {
                            array[k] = array[k - 1];
                        }
                        array[i] = temp;
                    }
                    if (array[i] % 2 != 0) {
                        break;
                    }
                }
            }
        }
    }
}
