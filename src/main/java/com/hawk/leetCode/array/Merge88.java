package com.hawk.leetCode.array;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组
 * 示例：输入：nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3 输出：[1,2,2,3,5,6]
 */
public class Merge88 {

    /**
     * 法一
     * 解题思路：建立一个 m+n 大小的新数组，然后逐个从 A 和 B 数组中取出元素比较，把较小的加入新数组
     * 然后再考虑 A 数组有剩余和 B 数组有剩余的两种情况
     * 最后再把新数组的元素重新赋值到 A 数组中即可
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (m <= 0 && n <= 0) {
            return;
        }
        int a = 0, b = 0;
        int[] nums3 = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            if (a < m && b < n) {
                if (nums1[a] < nums2[b]) {
                    nums3[i] = nums1[a];
                    a++;
                } else {
                    nums3[i] = nums2[b];
                    b++;
                }
            } else if (a < m && b >= n) {
                nums3[i] = nums1[a];
                a++;
            } else if (a >= m && b < n) {
                nums3[i] = nums2[b];
                b++;
            } else {
                return;
            }
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = nums3[i];
        }
    }

    /**
     * 法二
     * 解题思路：由于合并后 A 数组的大小必定是 m+n，所以从最后面开始往前赋值
     * 比较 A 和 B 中最后一个元素的大小，把较大的那个插入到 m+n-1 的位置上，再依次向前推
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int count = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            nums1[count--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        // 当 nums2 循环完，nums1 中还有元素时，剩余元素位置不变
        // 当 nums1 循环完，nums2 中还有元素时，把 nums2 中剩余元素覆盖到 nums1 剩下的位置
        while (n >= 0) {
            nums1[count--] = nums2[n--];
        }
    }
}
