package com.wjm.autumn;

import java.util.PriorityQueue;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Question021 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            integers.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < integers.peek()) continue;
            else {
                integers.poll();
                integers.offer(nums[i]);
            }
        }

        return integers.peek();
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        Question021 q = new Question021();
        int kthLargest = q.findKthLargest(a, 2);
        System.out.println(kthLargest);
    }
}
