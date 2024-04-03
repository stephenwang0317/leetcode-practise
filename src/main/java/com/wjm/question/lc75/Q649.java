package com.wjm.question.lc75;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q649 {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> r = new ArrayDeque<>();
        Queue<Integer> d = new ArrayDeque<>();
        char[] s = senate.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            if (r.peek() < d.peek()) {
                d.poll();
                r.offer(r.poll() + n);
            } else {
                r.poll();
                d.offer(d.poll() + n);
            }
        }
        if (r.isEmpty()) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }

    public static void main(String[] args) {
        Q649 q = new Q649();
        q.predictPartyVictory("RDD");
    }
}
