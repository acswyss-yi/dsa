package com.algorithms.validparentheses;

import java.util.Deque;
import java.util.ArrayDeque;

public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
/**
 * 核心逻辑（ValidParentheses.java:10-19）
 *
 *   遇左括号 → 压栈
 *   遇右括号 → 栈空直接 false；弹出栈顶，类型不匹配返回 false
 *   遍历结束 → 栈为空才是 true
 *
 *   测试覆盖场景：
 *
 *   ┌──────────────────┬────────────┬───────┐
 *   │       场景       │    输入    │ 期望  │
 *   ├──────────────────┼────────────┼───────┤
 *   │ 示例1 单对       │ ()         │ true  │
 *   ├──────────────────┼────────────┼───────┤
 *   │ 示例2 混合       │ ()[]{}     │ true  │
 *   ├──────────────────┼────────────┼───────┤
 *   │ 示例3 类型不匹配 │ (]         │ false │
 *   ├──────────────────┼────────────┼───────┤
 *   │ 嵌套有效         │ {[()]}     │ true  │
 *   ├──────────────────┼────────────┼───────┤
 *   │ 嵌套交叉         │ ([)]       │ false │
 *   ├──────────────────┼────────────┼───────┤
 *   │ 只有左括号       │ (          │ false │
 *   ├──────────────────┼────────────┼───────┤
 *   │ 只有右括号       │ )          │ false │
 *   ├──────────────────┼────────────┼───────┤
 *   │ 空字符串         │ ""         │ true  │
 *   ├──────────────────┼────────────┼───────┤
 *   │ 复合嵌套         │ {[()()]}[] │ true  │
 *   ├──────────────────┼────────────┼───────┤
 *   │ 未闭合嵌套       │ ((()       │ false │
 *   └──────────────────┴────────────┴───────┘
 *
 *   复杂度： 时间 O(n)，空间 O(n)
 * */