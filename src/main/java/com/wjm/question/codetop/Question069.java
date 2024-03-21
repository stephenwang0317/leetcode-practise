package com.wjm.question.codetop;

/**
 * @author stephen wang
 */
public class Question069 {
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        double err = 0.5;
        double t = x;

        while (Math.abs(t - x / t) > err * t) {
            t = (x / t + t) / 2.0;
        }

        return ((int) (t + 0.5)) - 1;
    }
}
