package com.algorithms.validparentheses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    private ValidParentheses solution;

    @BeforeEach
    void setUp() {
        solution = new ValidParentheses();
    }

    @Test
    void testSimplePair() {
        assertTrue(solution.isValid("()"));
    }

    @Test
    void testMixedPairs() {
        assertTrue(solution.isValid("()[]{}"));
    }

    @Test
    void testMismatchedBrackets() {
        assertFalse(solution.isValid("(]"));
    }

    @Test
    void testNestedValid() {
        assertTrue(solution.isValid("{[()]}"));
    }

    @Test
    void testNestedInvalid() {
        assertFalse(solution.isValid("([)]"));
    }

    @Test
    void testOnlyOpenBracket() {
        assertFalse(solution.isValid("("));
    }

    @Test
    void testOnlyCloseBracket() {
        assertFalse(solution.isValid(")"));
    }

    @Test
    void testEmptyString() {
        assertTrue(solution.isValid(""));
    }

    @Test
    void testLongValid() {
        assertTrue(solution.isValid("{[()()]}[]"));
    }

    @Test
    void testUnclosedNested() {
        assertFalse(solution.isValid("((()"));
    }
}
