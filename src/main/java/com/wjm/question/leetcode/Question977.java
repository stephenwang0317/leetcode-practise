package com.wjm.question.leetcode;

import java.util.Arrays;

/**
 * @author stephen wang
 */
public class Question977 {
    public int[] sortedSquares01(int[] nums) {
        // O(n+logn)
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1;
        int[] ans = new int[nums.length];
        for (int i = ans.length - 1; i > 0; i--) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                ans[i] = nums[l] * nums[l];
                l++;
            } else {
                ans[i] = nums[r] * nums[r];
                r--;
            }
        }
        return ans;
    }
}
