package com.wjm.question.hwexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExamTest0203 {
    static int cnt = 0;
    static int[][] map;
    static int N;
    static int[] vis;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N][N];
        vis = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        ArrayList<Integer> exposed = new ArrayList<>();
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        for (String s1 : split) {
            exposed.add(Integer.parseInt(s1));
        }
        int ans = -1, max = 0;
        for (Integer integer : exposed) {
            Arrays.fill(vis, 0);
            cnt = 1;
            vis[integer] = 1;
            dfs(integer, 10);
            if (cnt > max) {
                max = cnt;
                ans = integer;
            }
        }
        System.out.println(ans);
    }

    static void dfs(int index, int privilege) {
        for (int i = 0; i < N; i++) {
            if (map[index][i] > 0 && map[index][i] <= privilege && vis[i] == 0) {
                vis[i] = 1;
                cnt++;
                dfs(i, map[index][i]);
            }
        }
    }
}
