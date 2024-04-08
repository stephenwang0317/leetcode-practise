package com.wjm.question.hwexam;

import com.wjm.question.lc75.Q17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q179 {
    public String largestNumber(int[] nums) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] digits01, int[] digits02) {
                int i = 0;
                while (i < digits01.length && i < digits02.length) {
                    if (digits01[i] != digits02[i]) {
                        return digits02[i] - digits01[i];
                    }
                    i++;
                }
                if (i < digits01.length) {
                    int[] partOf01 = new int[digits01.length - i];
                    for (int j = 0, k = i; j < partOf01.length; j++, k++) {
                        partOf01[j] = digits01[k];
                    }
                    return compare(partOf01, digits02);
                } else if (i < digits02.length) {
                    int[] partOf02 = new int[digits02.length - i];
                    for (int j = 0, k = i; j < partOf02.length; j++, k++) {
                        partOf02[j] = digits02[k];
                    }
                    return compare(digits01, partOf02);
                } else {
                    return 0;
                }
            }
        };
        PriorityQueue<int[]> q = new PriorityQueue<>(comparator);
        for (int num : nums) {
            q.add(getDigits(num));
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i : poll) {
                sb.append(i);
            }
        }
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }

    int[] getDigits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        ArrayList<Integer> digits = new ArrayList<>();
        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }
        int[] ds = new int[digits.size()];
        for (int i = digits.size() - 1, j = 0; i >= 0; i--, j++) {
            ds[j] = digits.get(i);
        }
        return ds;
    }

    public static void main(String[] args) {
        Q179 q = new Q179();
        String s = q.largestNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        System.out.println(s);
    }
}
