package com.wjm.autumn;

import java.util.Arrays;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。
 * nums2 的长度为 n
 */
public class Question020 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ints = Arrays.copyOfRange(nums1, 0, m);
        int a = 0, b = 0, c = 0;
        while (a < m && b < n) {
            if (ints[a] < nums2[b]) {
                nums1[c] = ints[a];
                a++;
                c++;
            } else {
                nums1[c] = nums2[b];
                b++;
                c++;
            }
        }
        while (a < m) {
            nums1[c] = ints[a];
            a++;
            c++;
        }
        while (b < n) {
            nums1[c] = nums2[b];
            b++;
            c++;
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1, b = n - 1, c = m + n - 1;
        while (a >= 0 && b >= 0) {
            if (nums1[a] < nums2[b]) {
                nums1[c] = nums2[b];
                b--;
                c--;
            } else {
                nums1[c] = nums1[a];
                a--;
                c--;
            }
        }
        while (a >= 0) {
            nums1[c] = nums1[a];
            a--;
            c--;
        }
        while (b >= 0) {
            nums1[c] = nums2[b];
            b--;
            c--;
        }
    }

    public static void main(String[] args) {
        Question020 q = new Question020();
        int[] a = {1};

        q.merge2(a, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(a));
    }
}
