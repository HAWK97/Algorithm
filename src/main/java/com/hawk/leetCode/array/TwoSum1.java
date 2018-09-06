package com.hawk.leetCode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：给定一个整数数组和一个目标值，找出数组中和为目标值的两个数
 * 示例：给定 nums = [2, 7, 11, 15], target = 9，因为 nums[0] + nums[1] = 2 + 7 = 9，所以返回 [0, 1]
 */
public class TwoSum1 {

    /**
     * 两遍哈希表
     * 解题思路：我们需要一种更有效的方法来检查数组中是否存在目标元素
     * 如果存在，我们需要找出它的索引。保持数组中的每个元素与其索引相互对应的最好方法是哈希表
     * 复杂度分析：时间复杂度 O(n)，我们把包含有 n 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1)，所以时间复杂度为 O(n)
     * 空间复杂度 O(n)，所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 n 个元素
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // 第一次迭代数组，将每个元素的值和它的索引分别作为 key 和 value 添加到表中
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // 第二次迭代数组，检查每个元素所对应的目标元素（target - nums[i]）是否存在于表中
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希表
     * 解题思路：在进行迭代并将元素插入到表中的同时，我们还会回过头来检查表中是否已经存在当前元素所对应的目标元素
     * 复杂度分析：时间复杂度 O(n)，我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间
     * 空间复杂度 O(n)，所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
