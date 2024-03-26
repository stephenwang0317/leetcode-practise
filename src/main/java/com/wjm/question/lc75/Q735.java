package com.wjm.question.lc75;

import java.util.ArrayDeque;

public class Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(asteroids[0]);
        loop1:
        for (int i = 1; i < asteroids.length; i++) {
            int x = asteroids[i];
            while (!deque.isEmpty() && collid(x, deque.peekLast())) {
                int t = deque.pollLast();
                if (Math.abs(t) > Math.abs(x))
                    x = t;
                else if (Math.abs(t) == Math.abs(x))
                    continue loop1;
            }
            deque.offerLast(x);

        }
        int[] ret = new int[deque.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = deque.pollFirst();
        }
        return ret;
    }

    boolean collid(int a, int b) {
        return a < 0 && b > 0;
    }

    public static void main(String[] args) {
        Q735 q = new Q735();
        q.asteroidCollision(new int[]{10, 2, -5});
    }
}
