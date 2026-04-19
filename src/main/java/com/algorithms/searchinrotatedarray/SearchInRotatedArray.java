package com.algorithms.searchinrotatedarray;

/**
 * LeetCode 33 - Search in Rotated Sorted Array (Medium)
 *
 * A sorted array of distinct integers was rotated at an unknown pivot.
 * Given the rotated array and a target, return the index of target, or -1.
 *
 * Example 1:  nums = [4,5,6,7,0,1,2], target = 0  →  4
 * Example 2:  nums = [4,5,6,7,0,1,2], target = 3  → -1
 * Example 3:  nums = [1],             target = 0  → -1
 *
 * Approach: Modified binary search
 *   At every midpoint, one half is always sorted in order.
 *   Check whether target falls inside the sorted half and shrink accordingly.
 *
 * Time:  O(log n)
 * Space: O(1)
 */
public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) return mid;

            // Left half [lo..mid] is sorted
            if (nums[lo] <= nums[mid]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                // Right half [mid..hi] is sorted
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}
