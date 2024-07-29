package com.wjm.question.meituan;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (map[i][j] == map[i + 1][j] && map[i][j] == map[i][j + 1] &&
                        map[i][j] == map[i + 1][j + 1]){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
