package com.wjm.question.meituan2;

import java.util.Scanner;

public class Question01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int m = in.nextInt();

            int x = find(m);
            while (x != m) {
                m = x;
                x = find(x);
            }

            System.out.println(x);
        }
    }

    public static int find(int m) {
        int sqrt = (int) Math.sqrt((double) m);
        for (int i = 2; i <= sqrt; i++) {
            if (m % i == 0) return i;
        }
        return m;
    }
}
