package com.wjm.question.lc75;

import java.util.Arrays;

public class Q724 {
    public int pivotIndex(int[] nums) {
        //int sum = 0;
        int sum = Arrays.stream(nums).sum();
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur == sum - nums[i] -cur) return i;
            cur += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Q724 q = new Q724();
        q.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
    }
}
