package com.wjm.question.hwexam;

import java.util.PriorityQueue;

public class Q451 {
    public String frequencySort(String s) {
        char[] ss = s.toCharArray();
        int[] map = new int[128];
        for (char c : ss) {
            map[c]++;
        }
        PriorityQueue<Character> q = new PriorityQueue<>((a, b) -> map[b] - map[a]);
        for (int i = 0; i < 128; i++) {
            if (map[i] != 0) q.offer((char) i);
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Character poll = q.poll();
            for (int i = 0; i < map[poll]; i++) {
                sb.append(poll);
            }
        }
        return sb.toString();
    }
}
