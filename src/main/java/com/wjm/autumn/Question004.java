package com.wjm.autumn;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Question004 {
    boolean flag = true;

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            q.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < q.peek()) {
                continue;
            }
            q.poll();
            q.offer(nums[i]);
        }
        return q.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        qSort(0, nums.length - 1, nums, nums.length - 1 - (k - 1));
        return nums[nums.length - 1 - (k - 1)];
    }

    public void qSort(int l, int r, int[] nums, int k) {
        if (l >= r || !flag) return;

        int oriL = l, oriR = r;
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[r] > pivot) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= pivot) l++;
            nums[r] = nums[l];
        }

        nums[l] = pivot;
        if (l == k) {
            flag = false;
            return;
        }
        qSort(l + 1, oriR, nums, k);
        qSort(oriL, l - 1, nums, k);

    }

    public static void main(String[] args) {
        Question004 q = new Question004();
        System.out.println(q.findKthLargest2(new int[]{3,2,1,5,6,4}, 2));
    }
}
