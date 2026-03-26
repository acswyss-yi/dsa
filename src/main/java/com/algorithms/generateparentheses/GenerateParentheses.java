package com.algorithms.generateparentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}

/**
 * LeetCode 22 - Generate Parentheses（中等）
 *
 * 题目：给定 n 对括号，生成所有合法的括号组合。
 *
 * 核心逻辑（GenerateParentheses.java:13-25）
 *
 *   回溯三条件：
 *     1. 当前字符串长度 == 2*n → 加入结果
 *     2. open < n            → 可以继续添加 '('
 *     3. close < open        → 可以添加 ')'（保证合法性）
 *
 *   测试覆盖场景：
 *
 *   ┌──────┬───┬────────────────────────────────────┐
 *   │ 场景 │ n │              期望结果               │
 *   ├──────┼───┼────────────────────────────────────┤
 *   │ 示例1 │ 1 │ ["()"]                             │
 *   ├──────┼───┼────────────────────────────────────┤
 *   │ 示例2 │ 2 │ ["(())", "()()"]                   │
 *   ├──────┼───┼────────────────────────────────────┤
 *   │ 示例3 │ 3 │ ["((()))","(()())","(())()","()(())","()()()"] │
 *   └──────┴───┴────────────────────────────────────┘
 *
 *   复杂度：时间 O(4^n / √n)（卡特兰数），空间 O(n)（递归栈深度）
 */
