package com.wjm.autumn;

import java.util.Arrays;

public class Question028 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        Question028 q = new Question028();
        System.out.println(q.change(5, new int[]{1, 2, 5}));
    }
}
