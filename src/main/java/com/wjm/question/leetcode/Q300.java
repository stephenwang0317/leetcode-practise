package com.wjm.question.leetcode;

import java.util.Arrays;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > tails[p]) {
                tails[++p] = nums[i];
            } else if (nums[i] <= tails[0]) {
                tails[0] = nums[i];
            } else {
                func(tails, p, nums[i]);
            }
        }
        return p + 1;
    }

    void func(int[] tails, int p, int num) {
        int l = 0, r = p;
        while (r - l > 1) {
            int mid = (r + l) / 2;
            if (tails[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if (tails[r] > num)
            tails[r] = num;
    }

    public static void main(String[] args) {
        Q300 q = new Q300();
        System.out.println(q.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));            // 3
        System.out.println(q.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));   // 4
        System.out.println(q.lengthOfLIS(new int[]{1, 2, -10, -8, -7}));            // 3
        System.out.println(q.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));           // 6
        System.out.println(q.lengthOfLIS(new int[]{5,7,-24,12,13,2,3,12,5,6,35}));

    }
}
