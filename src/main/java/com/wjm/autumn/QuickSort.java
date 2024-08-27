package com.wjm.autumn;

import java.util.Arrays;

public class QuickSort {
    public static int[] sortArray(int[] nums) {
        qSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void qSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int pivot = nums[l];
        int oL = l, oR = r;
        while (l < r) {
            while (l < r && nums[r] > pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        qSort(nums, oL, l - 1);
        qSort(nums, l + 1, oR);
    }

    public static void main(String[] args) {
        int[] ints = QuickSort.sortArray(new int[]{5, 1, 1, 2, 0, 0});
        System.out.println(Arrays.toString(ints));
    }
}
