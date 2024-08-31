package com.wjm.question.ifly;

import java.util.Scanner;

public class Question01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int h = scanner.nextInt();
            int r = scanner.nextInt();
            int x0 = scanner.nextInt();
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            boolean func = func(h, r, x0, v1, v2);
            System.out.println(func?"Yes":"No");
        }
    }

    static boolean func(int h, int r, int x0, int v1, int v2) {
        double sqrt = Math.sqrt(h * h + x0 * x0);
        double time = sqrt / v2;
        double ziPos = v1 * time;
        if (ziPos < x0 - r) {
            return false;
        }
        if (ziPos > x0 + r) {
            return false;
        }
        return true;
    }
}
