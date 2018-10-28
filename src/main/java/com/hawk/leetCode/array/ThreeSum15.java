package com.hawk.leetCode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目描述：给定一个包含 n 个整数的数组 nums
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组
 * 示例：例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum15 {

    /**
     * 网上答案
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0 || nums[nums.length - 1] < 0 || nums[0] > 0) {
            return list;
        }
        for (int k = 0; k < nums.length; k++) {
            // 如果第一个要 fix 的数就是正数了，那么后面的数字就都是正数，就永远不会出现和为0的情况了
            if (nums[k] > 0) {
                break;
            }
            // 从第二个数开始，如果和前面的数字相等就跳过，因为我们不想把相同的数字 fix 两次
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int target = 0 - nums[k];
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    List<Integer> subList = Arrays.asList(k, i, j);
                    list.add(subList);
                    // 跳过重复数字，两个指针都需要检测重复数字
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                }
                // 如果两数之和小于 target，则我们将左边那个指针 i 右移一位，使得指向的数字增大一些
                // 同理，如果两数之和大于 target，则我们将右边那个指针 j 左移一位，使得指向的数字减小一些
                else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return list;
    }
}
