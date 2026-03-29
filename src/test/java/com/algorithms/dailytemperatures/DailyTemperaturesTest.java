package com.algorithms.dailytemperatures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperaturesTest {

    private DailyTemperatures solution;

    @BeforeEach
    void setUp() {
        solution = new DailyTemperatures();
    }

    @Test
    void testStandard() {
        assertArrayEquals(
            new int[]{1, 1, 4, 2, 1, 1, 0, 0},
            solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})
        );
    }

    @Test
    void testDecreasing() {
        assertArrayEquals(
            new int[]{0, 0, 0, 0, 0},
            solution.dailyTemperatures(new int[]{5, 4, 3, 2, 1})
        );
    }

    @Test
    void testIncreasing() {
        assertArrayEquals(
            new int[]{1, 1, 1, 1, 0},
            solution.dailyTemperatures(new int[]{1, 2, 3, 4, 5})
        );
    }

    @Test
    void testAllEqual() {
        assertArrayEquals(
            new int[]{0, 0, 0},
            solution.dailyTemperatures(new int[]{3, 3, 3})
        );
    }

    @Test
    void testSingleElement() {
        assertArrayEquals(
            new int[]{0},
            solution.dailyTemperatures(new int[]{42})
        );
    }

    @Test
    void testTwoElementsWarmer() {
        assertArrayEquals(
            new int[]{1, 0},
            solution.dailyTemperatures(new int[]{30, 40})
        );
    }
}
