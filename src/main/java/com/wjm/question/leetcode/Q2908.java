package com.wjm.question.leetcode;

public class Q2908 {
    public int minimumSum(int[] nums) {
        int[] left = new int[nums.length], right = new int[nums.length];
        left[0] = Integer.MAX_VALUE;
        right[nums.length - 1] = Integer.MAX_VALUE;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur < nums[i]) {
                left[i] = cur;
            } else {
                cur = nums[i];
            }
        }
        cur = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (cur < nums[i]) {
                right[i] = cur;
            } else {
                cur = nums[i];
            }
        }
        int ans = -1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (left[i] > 0 && right[i] > 0) {
                if (ans > 0)
                    ans = Math.min(ans, left[i] + right[i]+nums[i]);
                else
                    ans = left[i] + right[i]+nums[i];
            }
        }
        return ans;
    }
}
