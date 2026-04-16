package com.algorithms.besttimetobuysellstock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuySellStockTest {

    private BestTimeToBuySellStock solution;

    @BeforeEach
    void setUp() {
        solution = new BestTimeToBuySellStock();
    }

    // [7,1,5,3,6,4] → 5  (buy day2=1, sell day5=6)
    @Test
    void testStandard() {
        assertEquals(5, solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    // [7,6,4,3,1] → 0  (strictly decreasing, no profit)
    @Test
    void testDecreasing() {
        assertEquals(0, solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    // [1,2] → 1
    @Test
    void testTwoDaysProfit() {
        assertEquals(1, solution.maxProfit(new int[]{1, 2}));
    }

    // [2,1] → 0  (only one way, but sell < buy)
    @Test
    void testTwoDaysNoProfit() {
        assertEquals(0, solution.maxProfit(new int[]{2, 1}));
    }

    // [1] → 0  (single day, can't sell)
    @Test
    void testSingleDay() {
        assertEquals(0, solution.maxProfit(new int[]{1}));
    }

    // [3,3,3,3] → 0  (all equal)
    @Test
    void testAllEqual() {
        assertEquals(0, solution.maxProfit(new int[]{3, 3, 3, 3}));
    }

    // [2,4,1,7] → 6  (buy at 1, sell at 7)
    @Test
    void testMinNotAtStart() {
        assertEquals(6, solution.maxProfit(new int[]{2, 4, 1, 7}));
    }

    // [1,2,3,4,5] → 4  (buy day1, sell day5)
    @Test
    void testIncreasing() {
        assertEquals(4, solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }
}
