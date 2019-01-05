package com.hawk.leetCode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述：给定一个没有重复数字的序列，返回其所有可能的全排列
 * 示例：输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute46 {

    /**
     * 网上答案
     */
    private void permuteHelper(int[] nums, int i, List<List<Integer>> list) {
        if (i == nums.length - 1) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                subList.add(nums[j]);
            }
            list.add(subList);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                permuteHelper(nums, i + 1, list);
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        permuteHelper(nums, 0, res);
        return res;
    }
}
