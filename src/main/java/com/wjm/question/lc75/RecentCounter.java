package com.wjm.question.lc75;

import java.util.ArrayDeque;

class RecentCounter {
    private ArrayDeque<Integer> deque;

    public RecentCounter() {
        deque = new ArrayDeque<>();
    }

    public int ping(int t) {
        while (!deque.isEmpty() && deque.peekFirst() < t - 3000) {
            deque.pollFirst();
        }
        deque.offerLast(t);
        return deque.size();
    }
}