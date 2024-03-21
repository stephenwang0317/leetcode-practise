package com.wjm.question.codetop;

import com.wjm.utils.InputConverter;

import java.util.*;

/**
 * @author stephen wang
 */
public class Question056 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> arr = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                arr.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }

        arr.add(new int[]{start, end});
        return arr.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] a = InputConverter.stringToIntArray("[[1,4],[4,5]]");
        Question056 q = new Question056();

        int[][] merge = q.merge(a);
        Arrays.stream(merge).forEach(s-> {
            Arrays.stream(s).forEach(System.out::print);
            System.out.println();
        });
    }
}
