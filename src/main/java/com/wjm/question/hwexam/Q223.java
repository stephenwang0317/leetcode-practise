package com.wjm.question.hwexam;

public class Q223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int S1 = (ax2 - ax1) * (ay2 - ay1), S2 = (bx2 - bx1) * (by2 - by1);
        int x = 0, y = 0;
        if (between(ax1, ax2, bx1)) {
            if (between(ax1, ax2, bx2)) {
                x = bx2 - bx1;
            } else {
                x = ax2 - bx1;
            }
        } else if (between(ax1, ax2, bx2)) {
            x = bx2 - ax1;
        } else if (between(bx1, bx2, ax1)) {
            if (between(bx1, bx2, ax2)) {
                x = ax2 - ax1;
            } else {
                x = bx2 - ax1;
            }
        } else if (between(bx1, bx2, ax2)) {
            x = ax2 - bx1;
        }

        if (between(ay1, ay2, by1)) {
            if (between(ay1, ay2, by2)) {
                y = by2 - by1;
            } else {
                y = ay2 - by1;
            }
        } else if (between(ay1, ay2, by2)) {
            y = by2 - ay1;
        } else if (between(by1, by2, ay2)) {
            if (between(by1, by2, ay1)) {
                y = ay2 - ay1;
            } else {
                y = ay2 - by1;
            }
        } else if (between(by1, by2, ay1)) {
            y = by2 - ay1;
        }
        return S1 + S2 - x * y;
    }

    public boolean between(int a, int b, int x) {
        return a <= x && x <= b;
    }

    public static void main(String[] args) {
        Q223 q = new Q223();
        System.out.println(
                q.computeArea(-2, -2, 2, 2, -3, -3, 3, -1));

    }
}
