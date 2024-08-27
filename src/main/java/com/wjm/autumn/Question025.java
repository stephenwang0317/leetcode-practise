package com.wjm.autumn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class Question025 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0 || nums.length < 2) return false;
        int[] dp = new int[sum / 2 + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j <= sum / 2; j++) {
                if (dp[j] == 0) continue;
                a.add(j);
            }
            for (Integer integer : a) {
                if (integer + nums[i] < sum / 2 + 1) {
                    dp[integer + nums[i]] = 1;
                }
            }
        }
        return dp[sum / 2] == 1;
    }

    public static void main(String[] args) {
        Question025 q = new Question025();
        boolean b = q.canPartition(new int[]{1, 5, 11, 5});
        System.out.println(b);
    }
}
