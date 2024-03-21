package com.wjm.question.codetop;
/*
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * */

import java.util.Arrays;

/**
 * @author stephen wang
 */
public class Question300 {
    public int lengthOfLIS(int[] nums) {
        int[] map = new int[nums.length];
        Arrays.fill(map, 1);
        //map[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    map[i] = Math.max(map[i], map[j] + 1);
                }
            }
            if (map[i] > max) {
                max = map[i];
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] b = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        int[] c = new int[]{0, 1, 0, 3, 2, 3};
        int[] d = new int[]{7, 7, 7, 7, 7, 7, 7};
        Question300 q = new Question300();
        System.out.println(q.lengthOfLIS(a));
        System.out.println(q.lengthOfLIS(b));
        System.out.println(q.lengthOfLIS(c));
        System.out.println(q.lengthOfLIS(d));
    }
}

/*
 * 5 3 7
 * 1 1 0
 * 0 1 0
 * 0 0 1
 * */