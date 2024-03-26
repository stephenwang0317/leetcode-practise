package com.wjm.question.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author stephen wang
 */
public class Question518 {
    int ans = 0;

    public int change(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        Question518 q = new Question518();
        System.out.println(q.change(new int[]{1, 2, 5}, 5));
    }
}
