package com.wjm.question.lc75;

public class Q1732 {
    public int largestAltitude(int[] gain) {
        int cur = 0;
        int max = cur;
        for (int i = 0; i < gain.length; i++) {
            cur += gain[i];
            max = Math.max(cur, max);
        }
        return max;
    }
}
