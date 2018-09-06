package com.hawk.leetCode.array;

/**
 * 题目描述：给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度
 * 示例：给定数组 nums = [1,1,2], 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2
 */
public class RemoveDuplicates26 {

    /**
     * 我的答案
     */
    public int removeDuplicates1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxPos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != max) {
                max = nums[i];
                nums[++maxPos] = max;
            }
        }
        return maxPos + 1;
    }

    /**
     * 双指针法
     * 解题思路：放置两个指针 i 和 j，其中 i 是慢指针，而 j 是快指针
     * 只要 nums[i] = nums[j]，我们就增加 j 以跳过重复项
     * 当我们遇到 nums[j]≠nums[i] 时，说明 nums[j] 已经不是重复项了
     * 因此我们必须把它（nums[j]）的值复制到 nums[i + 1]。然后递增 i
     * 接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止
     * 算法复杂度：时间复杂度 O(n)，假设数组的长度是 n，那么 i 和 j 分别最多遍历 n 步
     * 空间复杂度 O(1)
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
