package com.hawk.algorithms.simplifiedSort;

public class ShellSort {

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
     * 基本思想：取一个小于 n 的整数 feet（即步长）将待排序元素分成若干个子序列
     * 所有距离为 feet 的记录放在同一个组中，然后对组内的元素进行直接插入排序
     * 这一趟完成之后，每一组的元素都是有序的
     * 然后减小 feet 的值，并重复执行上述的分组和排序
     * 当 feet = 1 时，整个数组就是有序的
     */
    private static int[] shellSort(int[] a, int n) {
        int feet = n / 2;
        while (feet >= 1) {
            for (int i = feet; i < n; i++) {
                for (int j = i; j >= feet && a[j] < a[j - feet]; j--) {
                    swap(a, j, j - feet);
                }
            }
            feet /= 2;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {20, 40, 30, 10, 60, 50};
        shellSort(a, a.length);
        show(a);
    }
}
