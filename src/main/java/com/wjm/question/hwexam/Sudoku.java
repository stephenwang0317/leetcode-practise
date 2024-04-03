package com.wjm.question.hwexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {
    static ArrayList<int[]> zeroPos = new ArrayList<>();
    static boolean conti = true;
    static int[][] ans = new int[9][9];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = in.nextInt();
                if (map[i][j] == 0) {
                    zeroPos.add(new int[]{i, j});
                }
            }
        }
        dfs(map, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j < 8)
                    System.out.print(ans[i][j] + " ");
                else
                    System.out.println(ans[i][j]);
            }
        }
    }

    public static void dfs(int[][] map, int cnt) {
        if (cnt == zeroPos.size()) {
            for (int i = 0; i < 9; i++) {
                System.arraycopy(map[i], 0, ans[i], 0, 9);
            }
            conti = false;
            return;
        }
        int x = zeroPos.get(cnt)[0], y = zeroPos.get(cnt)[1];
        for (int i = 1; i <= 9 && conti; i++) {
            if (check01(map, x, y, i)) {
                map[x][y] = i;
                dfs(map, cnt + 1);
                map[x][y] = 0;
            }
        }
    }

    public static boolean check01(int[][] map, int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == num) return false;
        }
        for (int i = 0; i < 9; i++) {
            if (map[i][y] == num) return false;
        }
        int X = x / 3, Y = y / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[3 * X + i][3 * Y + j] == num) return false;
            }
        }
        return true;
    }
}
