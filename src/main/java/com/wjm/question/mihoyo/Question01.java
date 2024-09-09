package com.wjm.question.mihoyo;

import java.util.Scanner;

public class Question01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int max = -1;
        int ans = -1;
        for (int i = n; i <= m; i++) {
            int cnt = 0;
            int x = i;
            while (x != 0) {
                cnt += (x % 10 == 4 || x % 10 == 6) ? 1 : 0;
                x /= 10;
            }
            if (cnt >= max) {
                max = cnt;
                ans = i;
            }
        }
        System.out.println(ans);
    }
}
