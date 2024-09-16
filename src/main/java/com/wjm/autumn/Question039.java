package com.wjm.autumn;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

public class Question039 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length) dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Question039 q = new Question039();
        int jump = q.jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(jump);
    }
}
