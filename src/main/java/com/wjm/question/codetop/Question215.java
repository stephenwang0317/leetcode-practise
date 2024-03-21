package com.wjm.question.codetop;



/*
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 */

import java.util.Arrays;

/**
 * @author stephen wang
 */
public class Question215 {
    public int findKthLargest(int[] nums, int k) {
        SmallHeap heap = new SmallHeap(k);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                heap.insert(nums[i]);
            } else {
                if (nums[i] < heap.data[1]) {
                    continue;
                } else {
                    heap.data[1] = nums[i];
                    heap.siftDown();
                }
            }
        }
        return heap.data[1];
    }

    static class SmallHeap {
        int[] data;
        int cap;
        int size;

        SmallHeap(int capacity) {
            cap = capacity;
            data = new int[cap + 2];
            Arrays.fill(data, Integer.MAX_VALUE);
            size = 0;
        }

        int insert(int num) {

            if (size < cap) {
                data[size + 1] = num;
                size++;
                siftUp();

            } else {
                data[cap + 1] = num;
                siftUp();
            }
            return data[0];
        }

        void siftUp() {
            int i = size;
            while (i > 1 && data[i] < data[i / 2]) {
                int t = data[i];
                data[i] = data[i / 2];
                data[i / 2] = t;
                i/=2;
            }
        }

        void siftDown() {
            int i = 1;
            while (i <= size/2 && (data[i] > data[2 * i] || data[i] > data[2 * i + 1])) {
                if (data[2 * i] > data[2 * i + 1]) {
                    swap(i, 2 * i + 1);
                    i = 2 * i + 1;
                } else {
                    swap(i, 2 * i);
                    i = 2 * i;
                }
            }
        }

        void swap(int i, int j) {
            int t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

    }

    public static void main(String[] args) {
        Question215 c = new Question215();
        System.out.println(c.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}