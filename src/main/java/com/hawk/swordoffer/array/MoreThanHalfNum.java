package com.hawk.swordoffer.array;

import java.util.HashMap;

/**
 * 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 * 如果不存在则输出 0
 */
public class MoreThanHalfNum {

    /**
     * 我的答案
     */
    public int MoreThanHalfNum_Solution1(int [] array) {
        if (array.length == 1) {
            return array[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                if (map.get(array[i]) == (array.length / 2)) {
                    return array[i];
                }
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        return 0;
    }

    /**
     * 网上答案
     */
    public int MoreThanHalfNum_Solution2(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        // 数组中某一元素出现次数
        int times = 1;
        // 遍历数组，若与之前保存的数字相同，则次数加 1，否则次数减 1,
        // 若次数为 0，则保存下一个数字，并将次数置为 1
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        // 判断 result 是否符合条件
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                times++;
            }
        }
        return times > array.length / 2 ? result : 0;
    }
}
