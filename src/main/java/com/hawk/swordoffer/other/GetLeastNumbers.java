package com.hawk.swordoffer.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述：输入 n 个整数，找出其中最小的 k 个数
 * 示例：输入：4, 5, 1, 6, 2, 7, 3, 8
 * 输出：1, 2, 3, 4
 */
public class GetLeastNumbers {

    /**
     * 网上答案
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length < k || k == 0) {
            return result;
        }
        // 申请一个最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : input) {
            // 首先在最大堆中放入 k 个元素
            if (maxHeap.size() < k) {
                maxHeap.offer(i);
            }
            // 当堆顶元素大于当前元素时，移除堆顶元素，入队当前元素
            else if (maxHeap.peek() > i) {
                maxHeap.poll();
                maxHeap.offer(i);
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
