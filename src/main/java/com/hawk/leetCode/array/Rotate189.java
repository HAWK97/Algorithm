package com.hawk.leetCode.array;

/**
 * 题目描述：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 * 示例：输入: [1,2,3,4,5,6,7] 和 k = 3 输出: [5,6,7,1,2,3,4]
 */
public class Rotate189 {

    /**
     * 我的答案
     */
    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 使用额外的数组
     * 解题思路：使用一个额外的数组，将数组的每个元素放在正确的位置
     * 即原始数组中索引 i 处的数字放在索引（i + k）。 然后，我们将新数组复制到原始数组
     * 复杂度分析：时间复杂度 O(n)，总共遍历两次数组，一次遍历用于将数字放入新数组中，另一次遍历将新数组复制到原始数组
     * 空间复杂度 O(n)，使用相同大小的另一个数组
     */
    public void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    /**
     * 反转法
     * 解题思路：当我们旋转数组 k 次时，来自数组后端的k个元素到达前面，而前面的其余元素向后移动
     * 在这种方法中，我们首先反转数组的所有元素。 然后，反转前 k 个元素，然后反转其余的 n-k 元素，得到所需的结果
     * 复杂度分析：时间复杂度 O(n)，n个元素总共反转三次
     * 空间复杂度 O(1)，不使用额外空间
     */
    public void rotate3(int[] nums, int k) {
        // 若 k 为 nums.length 的倍数，旋转后仍然得到原数组
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
