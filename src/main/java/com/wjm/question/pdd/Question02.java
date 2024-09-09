package com.wjm.question.pdd;

import java.util.Arrays;
import java.util.Scanner;

public class Question02 {
    static long A = 1000000007L;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            int[] dp = new int[n];
            dp[0] = Math.max(0, nums[0]);
            for (int j = 1; j < nums.length; j++) {
                dp[j] = Math.max(dp[j - 1] + nums[j], nums[j]);
                dp[j] = Math.max(dp[j], 0);
            }
            long max = Arrays.stream(dp).max().getAsInt();
            long ans = 0;
            for (int j = 0; j < nums.length; j++) {
                ans += nums[j];
                ans = ans % A;
            }
            if (ans < 0) ans += A;
            max = max % A;

            int x = (int) (mPow(k) % A - 1);
            ans += (max * x);

            System.out.println(ans);
        }
    }

    static long mPow(int k) {
        long ans = 1;
        long tmp = 2;
        while (k != 0) {
            int x = k & 1;
            if (x == 1) {
                ans *= tmp;
                ans %= A;
                tmp %= A;
            }
            tmp *= tmp;
            tmp %= A;
            k = k >>> 1;
        }
        return ans;
    }
}
