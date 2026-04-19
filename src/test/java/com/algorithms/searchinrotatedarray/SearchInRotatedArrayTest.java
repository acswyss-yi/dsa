package com.algorithms.searchinrotatedarray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedArrayTest {

    private SearchInRotatedArray solution;

    @BeforeEach
    void setUp() {
        solution = new SearchInRotatedArray();
    }

    // [4,5,6,7,0,1,2], target=0 → 4
    @Test
    void testTargetInRightPortion() {
        assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    // [4,5,6,7,0,1,2], target=4 → 0 (pivot element itself)
    @Test
    void testTargetAtPivot() {
        assertEquals(0, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
    }

    // [4,5,6,7,0,1,2], target=6 → 2 (left sorted half)
    @Test
    void testTargetInLeftPortion() {
        assertEquals(2, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
    }

    // [4,5,6,7,0,1,2], target=3 → -1 (not present)
    @Test
    void testTargetNotFound() {
        assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    // [1], target=0 → -1
    @Test
    void testSingleElementNotFound() {
        assertEquals(-1, solution.search(new int[]{1}, 0));
    }

    // [1], target=1 → 0
    @Test
    void testSingleElementFound() {
        assertEquals(0, solution.search(new int[]{1}, 1));
    }

    // [1,3], target=3 → 1
    @Test
    void testTwoElementsFound() {
        assertEquals(1, solution.search(new int[]{1, 3}, 3));
    }

    // [3,1], target=1 → 1 (rotated two-element)
    @Test
    void testTwoElementsRotated() {
        assertEquals(1, solution.search(new int[]{3, 1}, 1));
    }

    // No rotation: [1,2,3,4,5], target=3 → 2
    @Test
    void testNoRotation() {
        assertEquals(2, solution.search(new int[]{1, 2, 3, 4, 5}, 3));
    }

    // [5,1,2,3,4], target=5 → 0 (target is first element after rotation)
    @Test
    void testTargetIsFirstElement() {
        assertEquals(0, solution.search(new int[]{5, 1, 2, 3, 4}, 5));
    }

    // [2,3,4,5,1], target=1 → 4 (target is last element after rotation)
    @Test
    void testTargetIsLastElement() {
        assertEquals(4, solution.search(new int[]{2, 3, 4, 5, 1}, 1));
    }
}
