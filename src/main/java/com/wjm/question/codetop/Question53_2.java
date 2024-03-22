package com.wjm.question.codetop;

import java.lang.reflect.Array;

/**
 * @author stephen wang
 */
public class Question53_2 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] + nums[i] > nums[i]) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }
            if (dp[i] > ans) ans = dp[i];
        }
        return ans;

    }
}
