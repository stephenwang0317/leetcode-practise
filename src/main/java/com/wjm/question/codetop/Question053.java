package com.wjm.question.codetop;

/*
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * */

/**
 * @author stephen wang
 */
public class Question053 {
    public int maxSubArray(int[] nums) {
        int[] map = new int[nums.length];
        map[0] = nums[0];
        int ans = map[0];
        for (int i = 1; i < nums.length; i++) {
            map[i] = Math.max(nums[i], map[i - 1] + nums[i]);
            if (map[i] > ans) {
                ans = map[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Question053 q = new Question053();
        System.out.println(q.maxSubArray(nums));
    }
}
