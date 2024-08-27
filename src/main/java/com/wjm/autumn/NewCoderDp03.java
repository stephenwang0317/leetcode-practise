package com.wjm.autumn;

public class NewCoderDp03 {

    public int minCostClimbingStairs(int[] cost) {
        // write code here
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        NewCoderDp03 q = new NewCoderDp03();
        System.out.println(q.minCostClimbingStairs(new int[]{1,100,1,1,1,90,1,1,80,1}));
    }
}
