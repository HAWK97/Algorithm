package com.hawk.swordoffer.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：统计一个数字在排序数组中出现的次数
 */
public class GetNumberOfK {

    /**
     * 我的答案
     */
    public int GetNumberOfK1(int [] array , int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        if (map.containsKey(k)) {
            return map.get(k);
        }
        return 0;
    }

    /**
     * 网上答案
     * 看见有序，第一时间需要想到二分查找！
     * 通过二分法求出第一次出现和最后一次出现的位置
     */
    public int GetNumberOfK2(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int first = getFirst(array, k);
        int last = getLast(array, k);
        if (first != -1 && last != -1) {
            return last - first + 1;
        }
        return 0;
    }

    /**
     * 查找第一次出现的位置
     */
    public int getFirst(int[] array, int k) {
        int length = array.length;
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            }
            // 当 mid 的前一个命中时，则减 1
            else if (mid - 1 >= 0 && array[mid - 1] == k) {
                end = mid - 1;
            }
            // 当 mid 命中且 mid 的前一个无法命中时，返回
            else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找最后一次出现的位置
     */
    public int getLast(int[] array, int k) {
        int length = array.length;
        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] > k) {
                end = mid - 1;
            } else if (array[mid] < k) {
                start = mid + 1;
            } else if (mid + 1 <= length - 1 && array[mid + 1] == k) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
