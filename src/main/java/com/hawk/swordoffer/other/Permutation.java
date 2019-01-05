package com.hawk.swordoffer.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目描述：输入一个字符串，按字典序打印出该字符串中字符的所有排列
 * 示例：输入：abc
 * 输出：abc, acb, bac, bca, cab, cba
 */
public class Permutation {

    /**
     * 网上答案，图片分析可查看
     * https://uploadfiles.nowcoder.com/images/20170705/7578108_1499250116235_8F032F665EBB2978C26C4051D5B89E90
     */
    private void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val)) {
                list.add(val);
            }
        } else {
            for (int j = i; j < cs.length; j++) {
                // 交换前后两个字符
                swap(cs, i, j);
                PermutationHelper(cs, i + 1, list);
                // 还原到交换前的状态，进入到下一个循环
                swap(cs, i, j);
            }
        }
    }

    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        PermutationHelper(str.toCharArray(), 0, res);
        Collections.sort(res);
        return res;
    }
}
