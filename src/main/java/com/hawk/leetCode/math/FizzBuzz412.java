package com.hawk.leetCode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：写一个程序，输出从 1 到 n 数字的字符串表示
 * 1.如果 n 是3的倍数，输出“Fizz”
 * 2.如果 n 是5的倍数，输出“Buzz”
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”
 * 示例：略
 */
public class FizzBuzz412 {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
