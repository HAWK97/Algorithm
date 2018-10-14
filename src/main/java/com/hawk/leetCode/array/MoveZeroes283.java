package com.hawk.leetCode.array;

/**
 * 题目描述：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 * 示例：输入: [0,1,0,3,12] 输出: [1,3,12,0,0]
 */
public class MoveZeroes283 {

    /**
     * 我的答案（双指针法）
     */
    public void moveZeroes1(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }

    /**
     * 交换法
     */
    public void moveZeroes2(int[] nums) {
        int lastIndex = 0, curIndex = 0;
        while (curIndex < nums.length) {
            if (nums[curIndex] != 0) {
                swap(nums, lastIndex, curIndex);
                lastIndex++;
            }
            curIndex++;
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
