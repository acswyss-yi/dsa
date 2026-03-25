package com.algorithms.mergeintervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    private MergeIntervals solution;

    @BeforeEach
    void setUp() {
        solution = new MergeIntervals();
    }

    @Test
    void testStandard() {
        int[][] result = solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        assertArrayEquals(new int[][]{{1, 6}, {8, 10}, {15, 18}}, result);
    }

    @Test
    void testTouchingBoundary() {
        int[][] result = solution.merge(new int[][]{{1, 4}, {4, 5}});
        assertArrayEquals(new int[][]{{1, 5}}, result);
    }

    @Test
    void testNoOverlap() {
        int[][] result = solution.merge(new int[][]{{1, 2}, {3, 4}});
        assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, result);
    }

    @Test
    void testFullyContained() {
        int[][] result = solution.merge(new int[][]{{1, 4}, {2, 3}});
        assertArrayEquals(new int[][]{{1, 4}}, result);
    }

    @Test
    void testSingleInterval() {
        int[][] result = solution.merge(new int[][]{{1, 5}});
        assertArrayEquals(new int[][]{{1, 5}}, result);
    }

    @Test
    void testUnsortedInput() {
        int[][] result = solution.merge(new int[][]{{3, 5}, {1, 4}});
        assertArrayEquals(new int[][]{{1, 5}}, result);
    }
}
