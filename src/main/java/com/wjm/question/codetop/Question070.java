package com.wjm.question.codetop;

/**
 * @author stephen wang
 */
public class Question070 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int a = 1, b = 2;
        for (int i = 2; i < n; i++) {
            if (i % 2 == 0) {
                a += b;
            } else {
                b += a;
            }
        }
        return Math.max(a,b);
    }
}
