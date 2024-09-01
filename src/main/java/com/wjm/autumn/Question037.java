package com.wjm.autumn;

import java.util.Arrays;

/**
 * 798. 得分最高的最小轮调
 * 给你一个数组 nums，我们可以将它按一个非负整数 k 进行轮调，
 * 这样可以使数组变为 [nums[k], nums[k + 1], ... nums[nums.length - 1], nums[0], nums[1], ..., nums[k-1]]
 * 的形式。此后，任何值小于或等于其索引的项都可以记作一分。
 * 例如，数组为 nums = [2,4,1,3,0]，我们按 k = 2 进行轮调后，它将变成 [1,3,0,2,4]。这将记为 3 分，因为 1 > 0 [不计分]、3 > 1 [不计分]、0 <= 2 [计 1 分]、2 <= 3 [计 1 分]，4 <= 4 [计 1 分]。
 * 在所有可能的轮调中，返回我们所能得到的最高分数对应的轮调下标 k 。如果有多个答案，返回满足条件的最小的下标 k 。
 */
public class Question037 {
    public int bestRotation(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i >= nums[i]) {
                arr[0]++;
                if (i - nums[i] + 1 < nums.length) arr[i - nums[i] + 1]--;
            }
            if (i + 1 < nums.length) arr[i + 1]++;
            if (nums.length + i - nums[i] + 1 < nums.length) arr[1 + nums.length + i - nums[i]]--;
        }

        int[] ans = new int[nums.length];
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            ans[i] = cur + arr[i];
            cur = ans[i];
        }

        int maxIndex = 0;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] > ans[maxIndex]) maxIndex = i;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Question037 q = new Question037();
        int i = q.bestRotation(new int[]{2, 3, 1, 4, 0});
        System.out.println(i);
    }
}
