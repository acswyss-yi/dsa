package com.algorithms.coinchange;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    private CoinChange solution;

    @BeforeEach
    void setUp() {
        solution = new CoinChange();
    }

    @Test
    void testStandard() {
        assertEquals(3, solution.coinChange(new int[]{1, 2, 5}, 11));
    }

    @Test
    void testNoSolution() {
        assertEquals(-1, solution.coinChange(new int[]{2}, 3));
    }

    @Test
    void testAmountZero() {
        assertEquals(0, solution.coinChange(new int[]{1}, 0));
    }

    @Test
    void testSingleCoinDivisible() {
        assertEquals(2, solution.coinChange(new int[]{5}, 10));
    }

    @Test
    void testSingleCoinNotDivisible() {
        assertEquals(-1, solution.coinChange(new int[]{3}, 7));
    }

    @Test
    void testMultipleCoins() {
        assertEquals(2, solution.coinChange(new int[]{1, 5, 10, 25}, 30));
    }
}
