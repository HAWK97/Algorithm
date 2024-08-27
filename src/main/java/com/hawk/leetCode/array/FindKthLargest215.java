package com.hawk.leetCode.array;

/**
 * 题目描述：给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素
 * 示例：输入: [3,2,1,5,6,4], k = 2 输出: 5
 */
public class FindKthLargest215 {

    /**
     * 快速排序
     * 解题思路：我们可以用快速排序来解决这个问题，先对原数组排序，再返回倒数第 k 个位置
     * 我们对数组 a[l⋯r] 做快速排序的过程是
     * 分解： 将数组 a[l⋯r] 「划分」成两个子数组 a[l⋯q−1]、a[q+1⋯r]，使得 a[l⋯q−1] 中的每个元素小于等于 a[q]，且 a[q] 小于等于 a[q+1⋯r] 中的每个元素
     * 其中，计算下标 q 也是「划分」过程的一部分
     * 解决： 通过递归调用快速排序，对子数组 a[l⋯q−1] 和 a[q+1⋯r] 进行排序
     * 合并： 因为子数组都是原址排序的，所以不需要进行合并操作，a[l⋯r] 已经有序
     * 上文中提到的 「划分」 过程是：从子数组 a[l⋯r] 中选择任意一个元素 x 作为主元，调整子数组的元素使得左边的元素都小于等于它，右边的元素都大于等于它， x 的最终位置就是 q
     * 由此可以发现每次经过「划分」操作后，我们一定可以确定一个元素的最终位置，即 x 的最终位置为 q
     * 并且保证 a[l⋯q−1] 中的每个元素小于等于 a[q]，且 a[q] 小于等于 a[q+1⋯r] 中的每个元素
     * 所以只要某次划分的 q 为倒数第 k 个下标的时候，我们就已经找到了答案
     * 在分解的过程当中，我们会对子数组进行划分，如果划分得到的 q 正好就是我们需要的下标，就直接返回 a[q]；否则，如果 q 比目标下标小，就递归右子区间，否则递归左子区间
     * 这样就可以把原来递归两个区间变成只递归一个区间，提高了时间效率。这就是「快速选择」算法
     * 复杂度分析：时间复杂度：O(n) 空间复杂度：O(logn)，递归使用栈空间的空间代价的期望为 O(logn)
     */
    public int findKthLargest1(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    int quickSelect(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[k];
        }

        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        if (k <= j) {
            return quickSelect(nums, l, j, k);
        } else {
            return quickSelect(nums, j + 1, r, k);
        }
    }

    /**
     * 堆排序
     * 解题思路：我们也可以使用堆排序来解决这个问题
     * 建立一个大根堆，做 k−1 次删除操作后堆顶元素就是我们要找的答案
     * 复杂度分析：时间复杂度：O(nlogn)，建堆的时间代价是 O(n)，删除的总代价是 O(klogn)，因为 k<n，故渐进时间复杂为 O(n+klogn)=O(nlogn)
     * 空间复杂度：O(logn)，即递归使用栈空间的空间代价
     */
    public int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = heapSize - 1; i > heapSize - k; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
