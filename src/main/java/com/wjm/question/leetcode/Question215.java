package com.wjm.question.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author stephen wang
 */
public class Question215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int num : nums) {
            int size = q.size();
            if (size < k) {
                q.add(num);
            } else {
                if (num > q.peek()) {
                    q.poll();
                    q.add(num);
                }
            }
        }
        return q.peek();
    }
}
