package com.algorithms.containerwithmostwater;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    private ContainerWithMostWater solution;

    @BeforeEach
    void setUp() {
        solution = new ContainerWithMostWater();
    }

    @Test
    void testStandard() {
        assertEquals(49, solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    void testTwoElements() {
        assertEquals(1, solution.maxArea(new int[]{1, 1}));
    }

    @Test
    void testAscending() {
        assertEquals(6, solution.maxArea(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void testDescending() {
        assertEquals(6, solution.maxArea(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    void testEqualHeights() {
        assertEquals(9, solution.maxArea(new int[]{3, 3, 3, 3}));
    }

    @Test
    void testSinglePeak() {
        assertEquals(8, solution.maxArea(new int[]{1, 2, 9, 2, 1}));
    }
}
