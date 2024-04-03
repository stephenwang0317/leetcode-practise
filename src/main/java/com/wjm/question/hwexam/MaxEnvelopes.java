package com.wjm.question.hwexam;

import com.wjm.utils.InputConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        ArrayList<int[]> lopes = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            lopes.add(new int[]{envelopes[i][0], envelopes[i][1]});
        }
        lopes.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (lopes.get(j)[1] < lopes.get(i)[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        MaxEnvelopes m = new MaxEnvelopes();
        int[][] ints = InputConverter.stringToIntArray(
                "[[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]]");
        System.out.println(m.maxEnvelopes(ints));
    }
}
