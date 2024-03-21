package com.wjm.question.codetop;

import java.util.Arrays;

/**
 * @author stephen wang
 */
public class Question088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, c = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[c] = nums1[i];
                i--;
                c--;
            } else {
                nums1[c] = nums2[j];
                j--;
                c--;
            }
        }
        if (i == -1) {
            while (j >= 0) {
                nums1[c] = nums2[j];
                j--;
                c--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 6, 0, 0, 0};
        int[] b = new int[]{1, 2, 3};
        Question088 question088 = new Question088();
        question088.merge(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
    }
}
