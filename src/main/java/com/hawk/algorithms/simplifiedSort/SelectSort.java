package com.hawk.algorithms.simplifiedSort;

public class SelectSort {

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
     * 基本思想：首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）
     * 再次，在剩下的元素中找到最小的元素，将它和数组的第二个元素交换位置。如此往复，直到将整个数组排序
     */
    private static int[] selectSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            // 当前下标和初始下标不相同时，进行交换
            if (min != i) {
                swap(a, min, i);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {20, 40, 30, 10, 60, 50};
        selectSort(a, a.length);
        show(a);
    }
}
