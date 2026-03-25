package com.algorithms.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);

        return result.toArray(new int[0][]);
    }
}

/**
 * LeetCode 56 - Merge Intervals（中等）
 *
 * 题目：给出若干区间，合并所有重叠的区间。
 *
 * 核心逻辑（MergeIntervals.java:10-22）
 *
 *   1. 按区间左端点排序
 *   2. 遍历：当前区间与 current 重叠 → 更新 current 右端点
 *              不重叠 → 将 current 加入结果，current 替换为当前区间
 *
 *   测试覆盖场景：
 *
 *   ┌──────────────────┬──────────────────────────────┬──────────────────┐
 *   │       场景        │             输入              │     期望结果      │
 *   ├──────────────────┼──────────────────────────────┼──────────────────┤
 *   │ 示例1 标准重叠    │ [[1,3],[2,6],[8,10],[15,18]] │ [[1,6],[8,10],[15,18]] │
 *   ├──────────────────┼──────────────────────────────┼──────────────────┤
 *   │ 示例2 端点相触    │ [[1,4],[4,5]]                │ [[1,5]]          │
 *   ├──────────────────┼──────────────────────────────┼──────────────────┤
 *   │ 无重叠            │ [[1,2],[3,4]]                │ [[1,2],[3,4]]    │
 *   ├──────────────────┼──────────────────────────────┼──────────────────┤
 *   │ 全部重叠          │ [[1,4],[2,3]]                │ [[1,4]]          │
 *   ├──────────────────┼──────────────────────────────┼──────────────────┤
 *   │ 单个区间          │ [[1,5]]                      │ [[1,5]]          │
 *   └──────────────────┴──────────────────────────────┴──────────────────┘
 *
 *   复杂度：时间 O(n log n)，空间 O(n)
 */
