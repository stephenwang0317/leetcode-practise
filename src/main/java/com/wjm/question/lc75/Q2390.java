package com.wjm.question.lc75;

import java.util.ArrayDeque;
import java.util.Stack;

public class Q2390 {
    public String removeStars(String s) {
        ArrayDeque<Object> deque = new ArrayDeque<>();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != '*') {
                deque.offerLast(ss[i]);
            } else {
                deque.pollLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.poll());
        }
        return sb.toString();
    }
}
