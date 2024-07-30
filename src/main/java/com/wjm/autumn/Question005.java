package com.wjm.autumn;

import java.util.Arrays;
import java.util.Random;

/**
 * Quick Sort
 */
public class Question005 {
    public int[] sortArray(int[] nums) {
        qSort(0, nums.length - 1, nums);
        return nums;
    }

    public void qSort(int l, int r, int[] nums) {
        if (l >= r) return;

        int oriL = l, oriR = r;
        int i = new Random().nextInt(r - l) + l;
        int t = nums[l];
        nums[l] = nums[i];nums[i]=t;
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] > pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        qSort(oriL, l - 1, nums);
        qSort(l + 1, oriR, nums);
    }

    public static void main(String[] args) {
        Question005 q = new Question005();
        int[] ints = q.sortArray(new int[]{110, 100, 0});
        System.out.println(Arrays.toString(ints));
    }
}
