package com.hawk.leetCode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：给定一个非负整数 numRows，生成杨辉三角的前 numRows 行
 * 示例：输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Generate118 {

    /**
     * 网上答案
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        list.add(firstList);
        while (list.size() < numRows) {
            List<Integer> subList = new ArrayList<>();
            // 注意：这时的 list.size()为当前行元素个数减一
            int size = list.size();
            for (int i = 0; i <= size; i++) {
                if (i == 0 || i == list.size()) {
                    subList.add(1);
                } else {
                    subList.add(list.get(size - 1).get(i - 1) + list.get(size - 1).get(i));
                }
            }
            list.add(subList);
        }
        return list;
    }
}
