package com.algorithms.minpathsum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinPathSumTest {

    private MinPathSum solution;

    @BeforeEach
    void setUp() {
        solution = new MinPathSum();
    }

    /** 示例：3x3 矩阵，路径 1→3→1→1→1 = 7 */
    @Test
    void testExample() {
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        assertEquals(7, solution.minPathSum(grid));
    }

    /** 单个元素 */
    @Test
    void testSingleCell() {
        assertEquals(5, solution.minPathSum(new int[][]{{5}}));
    }

    /** 单行：只能一路向右 */
    @Test
    void testSingleRow() {
        int[][] grid = {{1, 2, 3}};
        assertEquals(6, solution.minPathSum(grid));
    }

    /** 单列：只能一路向下 */
    @Test
    void testSingleColumn() {
        int[][] grid = {{1}, {2}, {3}};
        assertEquals(6, solution.minPathSum(grid));
    }

    /** 2x2 矩阵：选上路 1→2→4=7 vs 下路 1→3→4=8 */
    @Test
    void test2x2() {
        int[][] grid = {
            {1, 2},
            {3, 4}
        };
        assertEquals(7, solution.minPathSum(grid));
    }

    /** 含零的矩阵 */
    @Test
    void testWithZeros() {
        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        assertEquals(0, solution.minPathSum(grid));
    }

    /** 非方形矩阵 2x3 */
    @Test
    void testNonSquare() {
        int[][] grid = {
            {1, 2, 5},
            {3, 2, 1}
        };
        // 路径：1→2→2→1 = 6
        assertEquals(6, solution.minPathSum(grid));
    }
}
