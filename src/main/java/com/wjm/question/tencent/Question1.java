package com.wjm.question.tencent;

import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        //int[][] map = new int[N][N];
        int[] map = new int[N];
        for (int i = 0; i < M; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            char color = in.next().charAt(0);
            if (color == 'R') {
                if (map[a - 1] != -1) {
                    map[a - 1] = 1;
                }
                if (map[b - 1] != -1) {
                    map[b - 1] = 1;
                }
            } else {
                map[a - 1] = -1;
                map[b - 1] = -1;
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (map[i] != -1) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
