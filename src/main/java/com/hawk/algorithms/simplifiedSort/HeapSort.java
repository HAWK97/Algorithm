package com.hawk.algorithms.simplifiedSort;

public class HeapSort {

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
     * 基本思想：1.初始化堆：将数列 a[0...n - 1] 构造成最大堆
     * 2.交换数据：将 a[0] 和 a[n - 1] 交换，使 a[n - 1] 是 a[0...n - 1] 中的最大值
     * 然后将 a[0...n - 2] 重新调整为最大堆
     * 以此类推......
     */
    private static int[] heapSort(int[] a, int n) {
        // a[n / 2 - 1] 为 a[n - 1] 的父节点
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapAdjust(a, i, n - 1);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(a, i, 0);
            heapAdjust(a, 0, i - 1);
        }
        return a;
    }

    private static void heapAdjust(int[] a, int start, int end) {
        // a[2 * start + 1] 为 a[start] 的左子节点
        while (2 * start + 1 <= end) {
            int child = 2 * start + 1;
            // 比较左子节点与右子节点，获得其中的较大值
            if (child < end && a[child] < a[child + 1]) {
                child++;
            }
            if (a[child] > a[start]) {
                swap(a, child, start);
                start = child;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {20, 40, 30, 10, 60, 50};
        heapSort(a, a.length);
        show(a);
    }
}
