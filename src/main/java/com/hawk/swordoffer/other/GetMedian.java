package com.hawk.swordoffer.other;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述：得到一个数据流中的中位数
 * 使用 Insert() 方法读取数据流，使用 GetMedian() 方法获取当前读取数据的中位数
 */
public class GetMedian {

    private int count = 0;

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    /**
     * 网上答案
     * 解题思路：将数据分成较大和较小两部分
     * 取较大部分的最小值与较小部分的最大值获得中位数
     */
    public void Insert(Integer num) {
        if (count % 2 == 0) {
            // 当数据总数为偶数时，先进入大根堆
            // 由大根堆筛选后取最大元素进入小根堆
            maxHeap.offer(num);
            Integer maxNum = maxHeap.poll();
            minHeap.offer(maxNum);
        } else {
            // 当数据总数为奇数时，先进入小根堆
            // 由小根堆筛选后取最小元素进入大根堆
            minHeap.offer(num);
            Integer minNum = minHeap.poll();
            maxHeap.offer(minNum);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return new Double(minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }
}
