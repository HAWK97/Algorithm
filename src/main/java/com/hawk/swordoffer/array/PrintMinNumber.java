package com.hawk.swordoffer.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 题目描述：输入一个正整数数组，把数组里所有数字拼接起来排成一个数
 * 打印能拼接出的所有数字中最小的一个
 * 示例：输入：{3, 32, 321}
 * 输出：321323
 */
public class PrintMinNumber {

    /**
     * 网上答案
     */
    public String PrintMinNumber(int [] numbers) {
        String s = "";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        // 按每个数字前后相加进行比较，相加和较小的放在前面
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        for (int i : list) {
            s += i;
        }
        return s;
    }
}
