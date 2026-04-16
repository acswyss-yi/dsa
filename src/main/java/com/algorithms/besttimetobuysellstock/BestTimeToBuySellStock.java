package com.algorithms.besttimetobuysellstock;

/**
 * LeetCode 121 - Best Time to Buy and Sell Stock (Easy)
 *
 * Given an array prices where prices[i] is the price on day i,
 * return the maximum profit from one buy-then-sell transaction.
 * Return 0 if no profit is possible.
 *
 * Example 1:  prices = [7,1,5,3,6,4]  →  5  (buy at 1, sell at 6)
 * Example 2:  prices = [7,6,4,3,1]    →  0  (prices only fall)
 *
 * Approach: single pass
 *   Track the minimum price seen so far; at each day compute
 *   the potential profit and update the global maximum.
 *
 * Time:  O(n)
 * Space: O(1)
 */
public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
