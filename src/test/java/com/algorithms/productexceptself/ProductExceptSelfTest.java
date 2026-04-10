package com.algorithms.productexceptself;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductExceptSelfTest {

    private ProductExceptSelf solution;

    @BeforeEach
    void setUp() {
        solution = new ProductExceptSelf();
    }

    // [1,2,3,4] -> [24,12,8,6]
    @Test
    void testStandard() {
        assertArrayEquals(
            new int[]{24, 12, 8, 6},
            solution.productExceptSelf(new int[]{1, 2, 3, 4})
        );
    }

    // [-1,1,0,-3,3] -> [0,0,9,0,0]
    @Test
    void testWithZero() {
        assertArrayEquals(
            new int[]{0, 0, 9, 0, 0},
            solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3})
        );
    }

    // [2,3] -> [3,2]
    @Test
    void testTwoElements() {
        assertArrayEquals(
            new int[]{3, 2},
            solution.productExceptSelf(new int[]{2, 3})
        );
    }

    // [0,0] -> [0,0]  (two zeros)
    @Test
    void testTwoZeros() {
        assertArrayEquals(
            new int[]{0, 0},
            solution.productExceptSelf(new int[]{0, 0})
        );
    }

    // [1,1,1,1] -> [1,1,1,1]
    @Test
    void testAllOnes() {
        assertArrayEquals(
            new int[]{1, 1, 1, 1},
            solution.productExceptSelf(new int[]{1, 1, 1, 1})
        );
    }

    // [-2, -3, 4] -> [-12, 8, 6]
    @Test
    void testNegativeNumbers() {
        assertArrayEquals(
            new int[]{-12, 8, 6},
            solution.productExceptSelf(new int[]{-2, -3, 4})
        );
    }

    // [5] -> [1]  (single element: product of empty set = 1)
    @Test
    void testSingleElement() {
        assertArrayEquals(
            new int[]{1},
            solution.productExceptSelf(new int[]{5})
        );
    }
}
