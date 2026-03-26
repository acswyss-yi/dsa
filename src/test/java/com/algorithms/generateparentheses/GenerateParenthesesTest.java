package com.algorithms.generateparentheses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest {

    private GenerateParentheses solution;

    @BeforeEach
    void setUp() {
        solution = new GenerateParentheses();
    }

    @Test
    void testN1() {
        List<String> result = solution.generateParenthesis(1);
        assertEquals(List.of("()"), result);
    }

    @Test
    void testN2() {
        List<String> result = solution.generateParenthesis(2);
        assertEquals(2, result.size());
        assertTrue(result.containsAll(List.of("(())", "()()")));
    }

    @Test
    void testN3() {
        List<String> result = solution.generateParenthesis(3);
        assertEquals(5, result.size());
        assertTrue(result.containsAll(List.of("((()))", "(()())", "(())()", "()(())", "()()()")));
    }

    @Test
    void testAllResultsValid() {
        for (String s : solution.generateParenthesis(4)) {
            assertTrue(isValid(s), "Invalid combination: " + s);
        }
    }

    @Test
    void testN4Count() {
        assertEquals(14, solution.generateParenthesis(4).size());
    }

    @Test
    void testNoDuplicates() {
        List<String> result = solution.generateParenthesis(3);
        long distinct = result.stream().distinct().count();
        assertEquals(result.size(), distinct);
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
