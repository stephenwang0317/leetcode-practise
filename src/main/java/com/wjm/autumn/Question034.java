package com.wjm.autumn;

public class Question034 {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int max = Integer.MIN_VALUE;
        int l = 0, r = 0, remain = maxCost;
        for (; l < ss.length; l++) {
            while (r < ss.length && remain >= 0) {
                int delta = Math.abs((int) ss[r] - (int) tt[r]);
                if (remain >= delta) {
                    remain -= delta;
                    r++;
                } else {
                    break;
                }
            }
            max = Math.max(max, r - l);
            remain += Math.abs((int) ss[l] - (int) tt[l]);
        }

        return max;
    }

    public static void main(String[] args) {
        Question034 q = new Question034();
        int i = q.equalSubstring("abcd", "acde", 0);
        System.out.println(i);
    }
}
