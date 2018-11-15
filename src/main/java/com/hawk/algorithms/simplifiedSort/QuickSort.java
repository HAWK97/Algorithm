package com.hawk.algorithms.simplifiedSort;

public class QuickSort {

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 基本思想：选择一个基准数，通过一趟排序将要排序的数据分隔成独立的两部分
     * 基准数左侧的所有数据都比右侧的所有数据要小
     * 然后再按此方法对左右两部分数据分别进行快速排序
     */
    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        // 取最左边的值作为基准数
        int key = a[left];
        int l = left;
        int r = right;
        while (l < r) {
            // 从右往左找出小于基准数的值
            while (l < r && a[r] >= key) {
                r--;
            }
            while (l < r && a[l] <= key) {
                l++;
            }
            swap(a, l, r);
        }
        // 左右查找相遇后，把最左边的值（即基准值）与中间的值交换
        a[left] = a[l];
        a[l] = key;
        quickSort(a, left, l);
        quickSort(a, l + 1, right);
    }

    private static int[] quickSort(int[] a, int n) {
        quickSort(a, 0, n - 1);
        return a;
    }

    public static void main(String[] args) {
        int[] a = {20, 40, 30, 10, 60, 50};
        quickSort(a, a.length);
        show(a);
    }
}
