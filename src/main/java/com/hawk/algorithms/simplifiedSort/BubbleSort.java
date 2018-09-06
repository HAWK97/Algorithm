package com.hawk.algorithms.simplifiedSort;

public class BubbleSort {

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

    private static int[] bubbleSort(int[] a, int n) {
        if (a == null || n < 2) {
            return a;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {20, 40, 30, 10, 60, 50};
        bubbleSort(a, a.length);
        show(a);
    }
}
