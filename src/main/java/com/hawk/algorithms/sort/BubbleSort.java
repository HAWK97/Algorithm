package com.hawk.algorithms.sort;

public class BubbleSort {
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (!less(a[j], a[j + 1])) {
                    exch(a, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {20, 40, 30, 10, 60, 50};
        sort(a);
        show(a);
    }
}
