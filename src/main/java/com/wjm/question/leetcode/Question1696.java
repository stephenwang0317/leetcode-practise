package com.wjm.question.leetcode;

/**
 * @author stephen wang
 */
public class Question1696 {
    public int maxResult(int[] nums, int k) {
        int score = nums[0];
        for (int i = 0; i < nums.length - 1; ) {
            int step = 1;
            for (int j = 1; j <= k && i + j < nums.length; j++) {
                if (nums[i + step] < nums[i + j]) {
                    step = j;
                }
            }
            score += nums[i + step];
            i += step;
        }
        return score;
    }

    public static void main(String[] args) {
        Question1696 q = new Question1696();
        int[] a = new int[]{10,-5,-2,4,0,3};
        System.out.println(q.maxResult(a, 3));
    }
}
