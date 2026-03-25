package com.algorithms.threesum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    private ThreeSum solution;

    @BeforeEach
    void setUp() {
        solution = new ThreeSum();
    }

    @Test
    void testStandard() {
        List<List<Integer>> result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(-1, -1, 2)));
        assertTrue(result.contains(List.of(-1, 0, 1)));
    }

    @Test
    void testAllZeros() {
        List<List<Integer>> result = solution.threeSum(new int[]{0, 0, 0});
        assertEquals(1, result.size());
        assertTrue(result.contains(List.of(0, 0, 0)));
    }

    @Test
    void testNoSolution() {
        assertTrue(solution.threeSum(new int[]{0, 1, 1}).isEmpty());
    }

    @Test
    void testWithDuplicates() {
        List<List<Integer>> result = solution.threeSum(new int[]{-2, 0, 0, 2, 2});
        assertEquals(1, result.size());
        assertTrue(result.contains(List.of(-2, 0, 2)));
    }

    @Test
    void testNoDuplicateTriplets() {
        List<List<Integer>> result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        long distinct = result.stream().distinct().count();
        assertEquals(result.size(), distinct);
    }

    @Test
    void testTwoElements() {
        assertTrue(solution.threeSum(new int[]{0, 0}).isEmpty());
    }
}
