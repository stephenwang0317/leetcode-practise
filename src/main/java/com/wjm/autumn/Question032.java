package com.wjm.autumn;

public class Question032 {
    public int longestOnes(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int lSum = 0, rSum = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            rSum += (nums[r] == 0 ? 1 : 0);
            while (rSum - lSum > k) {
                lSum += (nums[l] == 0 ? 1 : 0);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Question032 q = new Question032();
        int[] arr = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(q.longestOnes(arr, 3));
    }
}
