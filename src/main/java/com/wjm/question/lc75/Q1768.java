package com.wjm.question.lc75;

public class Q1768 {
    public String mergeAlternately(String word1, String word2) {
        char[] ss1 = word1.toCharArray();
        char[] ss2 = word2.toCharArray();
        int p1 = 0, p2 = 0;
        StringBuilder sb = new StringBuilder();
        while (p1 < ss1.length && p2 < ss2.length) {
            sb.append(ss1[p1]);
            p1++;
            sb.append(ss2[p2]);
            p2++;
        }
        while (p1 < ss1.length) {
            sb.append(ss1[p1]);
            p1++;
        }
        while (p2 < ss2.length) {
            sb.append(ss2[p2]);
            p2++;
        }
        return sb.toString();
    }
}
