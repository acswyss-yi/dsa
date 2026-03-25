package com.algorithms.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}

/**
 * LeetCode 15 - 3Sum（中等）
 *
 * 题目：找出数组中所有和为 0 的不重复三元组。
 *
 * 核心逻辑（ThreeSum.java:12-30）
 *
 *   1. 排序数组，固定第一个数 nums[i]
 *   2. 双指针 left、right 在 i+1..end 范围内夹逼
 *   3. sum < 0 → left++；sum > 0 → right--；sum == 0 → 记录并跳过重复
 *
 *   测试覆盖场景：
 *
 *   ┌──────────────────────┬──────────────────────────┬──────────────────────────────┐
 *   │         场景          │           输入            │           期望结果            │
 *   ├──────────────────────┼──────────────────────────┼──────────────────────────────┤
 *   │ 示例1 标准            │ [-1,0,1,2,-1,-4]         │ [[-1,-1,2],[-1,0,1]]         │
 *   ├──────────────────────┼──────────────────────────┼──────────────────────────────┤
 *   │ 示例2 全零            │ [0,0,0]                  │ [[0,0,0]]                    │
 *   ├──────────────────────┼──────────────────────────┼──────────────────────────────┤
 *   │ 示例3 无解            │ [0,1,1]                  │ []                           │
 *   ├──────────────────────┼──────────────────────────┼──────────────────────────────┤
 *   │ 多重复元素             │ [-2,0,0,2,2]             │ [[-2,0,2]]                   │
 *   └──────────────────────┴──────────────────────────┴──────────────────────────────┘
 *
 *   复杂度：时间 O(n²)，空间 O(1)（不计结果空间）
 */
