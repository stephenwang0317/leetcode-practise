package com.wjm.question.leetcode;

import java.util.Arrays;

/**
 * @author stephen wang
 */
public class Question435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });
        return 0;
    }
}
