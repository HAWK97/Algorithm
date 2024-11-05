package com.hawk.leetCode.other;

/**
 * 题目描述：给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成
 * 示例：
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 */
public class NumIslands200 {

    /**
     * 深度优先搜索
     * 解题思路：我们可以将二维网格看成一个无向图，竖直或水平相邻的 1 之间有边相连
     * 为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为 1，则以其为起始节点开始进行深度优先搜索
     * 在深度优先搜索的过程中，每个搜索到的 1 都会被重新标记为 0
     * 最终岛屿的数量就是我们进行深度优先搜索的次数
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int gridRow = grid.length;
        int gridCol = grid[0].length;
        int count = 0;
        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        int gridRow = grid.length;
        int gridCol = grid[0].length;

        if (row < 0 || row >= gridRow || col < 0 || col >= gridCol) {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
