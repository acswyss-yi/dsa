package com.algorithms.containerwithmostwater;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}

/**
 * LeetCode 11 - Container With Most Water（中等）
 *
 * 题目：给定 n 个高度值，找两条线使其与 x 轴构成的容器能容纳最多的水。
 *
 * 核心逻辑（ContainerWithMostWater.java:6-15）
 *
 *   双指针从两端向中间收缩：
 *     面积 = min(height[left], height[right]) * (right - left)
 *     较矮一侧内移 → 可能找到更高的线，从而增大面积
 *
 *   测试覆盖场景：
 *
 *   ┌──────────────┬──────────────────────┬────────┐
 *   │     场景      │         输入          │ 期望   │
 *   ├──────────────┼──────────────────────┼────────┤
 *   │ 示例1 标准    │ [1,8,6,2,5,4,8,3,7] │ 49     │
 *   ├──────────────┼──────────────────────┼────────┤
 *   │ 示例2 两元素  │ [1,1]                │ 1      │
 *   ├──────────────┼──────────────────────┼────────┤
 *   │ 递增序列      │ [1,2,3,4,5]          │ 6      │
 *   ├──────────────┼──────────────────────┼────────┤
 *   │ 递减序列      │ [5,4,3,2,1]          │ 6      │
 *   ├──────────────┼──────────────────────┼────────┤
 *   │ 相等高度      │ [3,3,3,3]            │ 9      │
 *   └──────────────┴──────────────────────┴────────┘
 *
 *   复杂度：时间 O(n)，空间 O(1)
 */
