package com.algorithms.productexceptself;

/**
 * LeetCode 238 - Product of Array Except Self (Medium)
 *
 * Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time without using the division operation.
 *
 * Example:
 *   Input:  nums = [1, 2, 3, 4]
 *   Output: [24, 12, 8, 6]
 *
 * Approach: Two-pass prefix/suffix product
 *   - First pass (left to right): result[i] = product of all elements to the LEFT of i
 *   - Second pass (right to left): multiply result[i] by product of all elements to the RIGHT of i
 *
 * Time:  O(n)
 * Space: O(1) extra (output array not counted)
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // First pass: result[i] holds the product of all elements to the left of i
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Second pass: multiply by the running product of all elements to the right of i
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
