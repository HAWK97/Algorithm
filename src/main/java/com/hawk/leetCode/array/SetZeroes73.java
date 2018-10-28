package com.hawk.leetCode.array;

/**
 * 题目描述：给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法
 * 示例：输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 */
public class SetZeroes73 {

    /**
     * 网上答案
     * 为什么第一行第一列要单独考虑呢，有点不懂
     */
    public void setZeroes(int[][] matrix) {
        // 行数
        int m = matrix.length;
        // 列数
        int n = matrix[0].length;
        boolean rowZero = false, colZero = false;
        // 先扫描第一行第一列，如果有 0，则将各自的 flag 设置为 true
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colZero = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowZero = true;
            }
        }
        // 然后遍历除去第一行第一列的整个数组，如果有 0，则将对应的第一行和第一列的数字赋 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 再次遍历除去第一行第一列的整个数组，如果对应的第一行和第一列的数字有一个为 0，则将当前值赋 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 最后根据第一行第一列的 flag 来更新第一行第一列
        if (rowZero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
