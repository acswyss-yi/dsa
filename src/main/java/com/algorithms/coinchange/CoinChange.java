package com.algorithms.coinchange;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}

/**
 * LeetCode 322 - Coin Change（中等）
 *
 * 题目：给定面额数组 coins 和总金额 amount，求凑成 amount 所需最少硬币数。
 *       若无法凑成则返回 -1。
 *
 * 核心逻辑（CoinChange.java:8-16）
 *
 *   完全背包 DP：
 *   1. dp[i] 表示凑成金额 i 所需最少硬币数，初始化为 amount+1（表示不可达）
 *   2. dp[0] = 0（金额为0不需要硬币）
 *   3. 对每个金额 i，枚举每种硬币：dp[i] = min(dp[i], dp[i-coin] + 1)
 *   4. 最终 dp[amount] > amount 说明无解，返回 -1
 *
 *   测试覆盖场景：
 *
 *   ┌──────────────────────┬──────────────────────┬──────────┐
 *   │         场景          │         输入          │  期望结果 │
 *   ├──────────────────────┼──────────────────────┼──────────┤
 *   │ 标准示例1             │ coins=[1,2,5], amt=11 │    3     │
 *   ├──────────────────────┼──────────────────────┼──────────┤
 *   │ 无解                  │ coins=[2], amt=3      │   -1     │
 *   ├──────────────────────┼──────────────────────┼──────────┤
 *   │ 金额为0               │ coins=[1], amt=0      │    0     │
 *   ├──────────────────────┼──────────────────────┼──────────┤
 *   │ 单硬币整除            │ coins=[5], amt=10     │    2     │
 *   ├──────────────────────┼──────────────────────┼──────────┤
 *   │ 单硬币不整除          │ coins=[3], amt=7      │   -1     │
 *   ├──────────────────────┼──────────────────────┼──────────┤
 *   │ 多种面额              │ coins=[1,5,10,25], amt=30 │  2   │
 *   └──────────────────────┴──────────────────────┴──────────┘
 *
 *   复杂度：时间 O(amount × n)，空间 O(amount)
 */
