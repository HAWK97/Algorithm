package com.hawk.algorithms.simplifiedSort;

public class MergeSort {

    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = mid + 1;
        int tempIndex = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            temp[tempIndex++] = a[leftIndex] < a[rightIndex] ? a[leftIndex++] : a[rightIndex++];
        }
        while (leftIndex <= mid) {
            temp[tempIndex++] = a[leftIndex++];
        }
        while (rightIndex <= right) {
            temp[tempIndex++] = a[rightIndex++];
        }
        int t = 0;
        while ((t + left) <= right) {
            a[t + left] = temp[t];
            t++;
        }
    }

    private static void mSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mSort(a, left, mid);
        mSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private static int[] mergeSort(int[] a, int n) {
        mSort(a, 0, n - 1);
        return a;
    }

    public static void main(String[] args) {
        int[] a = {20, 40, 30, 10, 60, 50};
        mergeSort(a, a.length);
        show(a);
    }
}
