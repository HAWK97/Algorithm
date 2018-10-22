package com.hawk.leetCode.array;

import java.util.Random;

/**
 * 题目描述：打乱一个没有重复元素的数组
 * 示例：以数字集合 1, 2 和 3 初始化数组
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3] 的排列返回的概率应该相同
 * solution.shuffle();
 *
 * 重设数组到它的初始状态[1,2,3]
 * solution.reset();
 */
public class Shuffle384 {

    private int[] nums;

    private Random random;

    public Shuffle384(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] newNums = (int[]) nums.clone();
        for(int i = 1; i < nums.length; i++){
            int j = random.nextInt(i + 1);
            swap(newNums, i, j);
        }
        return newNums;
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
