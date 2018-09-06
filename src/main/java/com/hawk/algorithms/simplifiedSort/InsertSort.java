package com.hawk.algorithms.simplifiedSort;

// 把n个待排序的元素看成一个有序表和一个无序表。开始时有序表中只包含1个元素，无序表中包含n-1个元素
// 排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程
public class InsertSort {

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

    private static int[] insertSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                swap(a, j, j - 1);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {20, 40, 30, 10, 60, 50};
        insertSort(a, a.length);
        show(a);
    }
}
