package com.wjm.question.codetop;

import java.util.Arrays;

/**
 * @author stephen wang
 */
public class Question912 {
    public int[] sortArray(int[] nums) {
        qSort(nums, 0, nums.length - 1);
        return nums;
    }

    void qSort(int[] nums, int l, int r) {
        if (l > r) {
            return;
        }
        int a = l, b = r;
        int pivot = nums[(l + r) / 2];
        nums[(l + r) / 2] = nums[l];
        nums[l] = pivot;
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] < pivot) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        qSort(nums, a, l - 1);
        qSort(nums, l + 1, b);
    }
}
