package com.wjm.question.codetop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author stephen wang
 */
public class Question300_2 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > tails[p]) {
                tails[++p] = nums[i];
            } else {
                func(tails, p, nums[i]);
            }
        }
        return p + 1;
    }

    void func(int[] tails, int p, int num) {
        int l = 0, r = p;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (tails[mid] < num) {
                l = mid;
            } else {
                r = mid;
            }
        }
        tails[r] = num;
    }

    public static void main(String[] args) {
        Question300_2 q = new Question300_2();
        System.out.println(q.lengthOfLIS(new int[]{1, 2, -10, -8, -7}));
    }
}
