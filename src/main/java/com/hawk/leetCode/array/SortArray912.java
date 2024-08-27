package com.hawk.leetCode.array;

import java.util.Random;

/**
 * 题目描述：给你一个整数数组 nums，请你将该数组升序排列
 * 示例：输入：nums = [5,2,3,1] 输出：[1,2,3,5]
 */
public class SortArray912 {

    /**
     * 快速排序
     * 解题思路：快速排序的主要思想是通过划分将待排序的序列分成前后两部分，其中前一部分的数据都比后一部分的数据要小
     * 然后再递归调用函数对两部分的序列分别进行快速排序，以此使整个序列达到有序
     * 整个划分函数 partition 主要涉及两个指针 i 和 j，一开始 i = l - 1，j = l
     * 我们需要实时维护两个指针使得任意时候，对于任意数组下标 k，我们有如下条件成立
     * 1 l≤k≤i 时，nums[k]≤pivot
     * 2 i+1≤k≤j−1 时，nums[k]>pivot
     * 3 k==r 时，nums[k]=pivot
     * 我们每次移动指针 j ，如果 nums[j]>pivot，我们只需要继续移动指针 j ，即能使上述三个条件成立
     * 否则我们需要将指针 i 加一，然后交换 nums[i] 和 nums[j]，再移动指针 j 才能使得三个条件成立
     * 当 j 移动到 r−1 时结束循环，此时我们可以由上述三个条件知道 [l,i] 的数都小于等于主元 pivot，[i+1,r−1] 的数都大于主元 pivot
     * 那么我们只要交换 nums[i+1] 和 nums[r] ，即能使得 [l,i+1] 区间的数都小于 [i+2,r] 区间的数，完成一次划分，且分界值下标为 i+1，返回即可
     * 复杂度分析：时间复杂度：基于随机选取主元的快速排序时间复杂度为期望 O(nlogn)，其中 n 为数组的长度
     * 空间复杂度：O(h)，其中 h 为快速排序递归调用的层数。我们需要额外的 O(h) 的递归调用的栈空间
     * 由于划分的结果不同导致了快速排序递归调用的层数也会不同，最坏情况下需 O(n) 的空间，最优情况下每次都平衡，此时整个递归树高度为 logn，空间复杂度为 O(logn)
     */
    public int[] sortArray1(int[] nums) {
        randomizedQuicksort(nums, 0, nums.length - 1);
        return nums;
    }

    public void randomizedQuicksort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomizedPartition(nums, l, r);
            randomizedQuicksort(nums, l, pos - 1);
            randomizedQuicksort(nums, pos + 1, r);
        }
    }

    public int randomizedPartition(int[] nums, int l, int r) {
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    /**
     * 堆排序
     * 解题思路：堆排序的思想就是先将待排序的序列建成大根堆，使得每个父节点的元素大于等于它的子节点
     * 此时整个序列最大值即为堆顶元素，我们将其与末尾元素交换，使末尾元素为最大值
     * 然后再调整堆顶元素使得剩下的 n−1 个元素仍为大根堆，再重复执行以上操作我们即能得到一个有序的序列
     * 复杂度分析：时间复杂度：O(nlogn)。初始化建堆的时间复杂度为 O(n)，建完堆以后需要进行 n−1 次调整
     * 一次调整（即 maxHeapify） 的时间复杂度为 O(logn)，那么 n−1 次调整即需要 O(nlogn) 的时间复杂度
     * 因此，总时间复杂度为 O(n+nlogn)=O(nlogn)
     * 空间复杂度：O(1)。只需要常数的空间存放若干变量
     */
    public int[] sortArray2(int[] nums) {
        heapSort(nums);
        return nums;
    }

    public void heapSort(int[] nums) {
        int len = nums.length - 1;
        buildMaxHeap(nums, len);
        for (int i = len; i >= 1; --i) {
            swap(nums, i, 0);
            len -= 1;
            maxHeapify(nums, 0, len);
        }
    }

    public void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; --i) {
            maxHeapify(nums, i, len);
        }
    }

    public void maxHeapify(int[] nums, int i, int len) {
        for (; (i << 1) + 1 <= len;) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if (lson <= len && nums[lson] > nums[i]) {
                large = lson;
            } else {
                large = i;
            }
            if (rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }
            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 归并排序
     * 解题思路：归并排序利用了分治的思想来对序列进行排序。对一个长为 n 的待排序的序列，我们将其分解成两个长度为 n / 2的子序列
     * 每次先递归调用函数使两个子序列有序，然后我们再线性合并两个有序的子序列使整个序列有序
     * 定义 mergeSort(nums, l, r) 函数表示对 nums 数组里 [l,r] 的部分进行排序，整个函数流程如下
     * 1 递归调用函数 mergeSort(nums, l, mid) 对 nums 数组里 [l,mid] 部分进行排序
     * 2 递归调用函数 mergeSort(nums, mid + 1, r) 对 nums 数组里 [mid+1,r] 部分进行排序
     * 3 此时 nums 数组里 [l,mid] 和 [mid+1,r] 两个区间已经有序，我们对两个有序区间线性归并即可使 nums 数组里 [l,r] 的部分有序
     * 我们维护两个指针 i 和 j 表示当前 [l,mid] 里的第 i 个位置和 [mid+1,r] 的第 j 个位置
     * 如果 nums[i] <= nums[j] ，那么我们就将 nums[i] 放入临时数组 tmp 中并让 i += 1 ，即指针往后移
     * 否则我们就将 nums[j] 放入临时数组 tmp 中并让 j += 1
     * 如果有一个指针已经移到了区间的末尾，那么就把另一个区间里的数按顺序加入 tmp 数组中即可
     * 这样能保证我们每次都是让两个区间中较小的数加入临时数组里，那么整个归并过程结束后 [l,r] 即为有序的
     * 复杂度分析：时间复杂度：O(nlogn)。由于归并排序每次都将当前待排序的序列折半成两个子序列递归调用，然后再合并两个有序的子序列
     * 而每次合并两个有序的子序列需要 O(n) 的时间复杂度，所以我们可以列出归并排序运行时间 T(n) 的递归表达式：T(n)=2T(n / 2)+O(n)
     * 根据主定理我们可以得出归并排序的时间复杂度为 O(nlogn)
     * 空间复杂度：O(n)。我们需要额外 O(n) 空间的 tmp 数组，且归并排序递归调用的层数最深为 log2(n)
     * 所以我们还需要额外的 O(logn) 的栈空间，所需的空间复杂度即为 O(n+logn)=O(n)
     */
    int[] tmp;

    public int[] sortArray3(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int i = l, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }
        for (int k = 0; k < r - l + 1; ++k) {
            nums[k + l] = tmp[k];
        }
    }
}
