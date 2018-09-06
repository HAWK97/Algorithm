package com.hawk.leetCode.array;

import java.util.*;

/**
 * 题目描述：给定两个数组，写一个方法来计算它们的交集
 * 示例：给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2]
 */
public class Intersect350 {

    /**
     * 哈希表法
     * 解题思路：用 Map 来建立 nums1 中字符和其出现个数之间的映射, 然后遍历 nums2 数组
     * 如果当前字符在 Map 中的个数大于 0，则将此字符加入结果 res 中，然后 Map 的对应值自减 1
     * 时间复杂度：略
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        List<Integer> tmp = new ArrayList<>(Math.min(nums1.length, nums2.length));
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            Integer value = map.get(nums1[i]);
            map.put(nums1[i], (value == null ? 0 : value) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
                tmp.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] result = new int[tmp.size()];
        int i = 0;
        for (Integer e : tmp)
            result[i++] = e;
        return result;
    }

    /**
     * 排序法
     * 解题思路：给两个数组排序，然后用两个索引分别代表两个数组的起始位置
     * 如果两个索引所代表的数字相等，则将数字存入结果中，两个索引均自增 1
     * 如果第一个索引所代表的数字大，则第二个索引自增 1，反之第一个索引自增 1
     * 时间复杂度：略
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> tmp = new ArrayList<>(Math.min(nums1.length, nums2.length));
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums2[j] > nums1[i]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                tmp.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[tmp.size()];
        int k = 0;
        for (Integer e : tmp)
            result[k++] = e;
        return result;
    }
}
