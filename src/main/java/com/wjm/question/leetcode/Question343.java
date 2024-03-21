package com.wjm.question.leetcode;

/**
 * @author stephen wang
 */
public class Question343 {
    public static int integerBreak2(int n) {
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        if (n <= 3) {
            return dp[n];
        }

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int a = j <= 3 ? j : dp[j];
                int b = (i - j) <= 3 ? (i - j) : dp[i - j];
                dp[i] = Math.max(dp[i], a * b);
            }
        }
        return dp[n];
    }

    public static int integerBreak(int n) {
        if (n < 3) return 1;
        if (n == 3) return 2;
        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            int c = (n - 1) / 3;
            int ans = 1;
            for (int i = 0; i < c - 1; i++) {
                ans *= 3;
            }
            ans *= 4;
            return ans;
        } else {
            int c = (n - 2) / 3;
            int ans = 1;
            for (int i = 0; i < c; i++) {
                ans *= 3;
            }
            ans *= 2;
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
