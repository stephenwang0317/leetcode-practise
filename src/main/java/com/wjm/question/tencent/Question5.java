package com.wjm.question.tencent;

import java.util.Scanner;

public class Question5 {
    static char[][] map;
    static int[][] vis;
    static final char[] target = new char[]{'t', 'e', 'n', 'c', 'e', 'n', 't'};
    static int ans = 0;
    static int ROW, COL;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ROW = scanner.nextInt();
        COL = scanner.nextInt();
        map = new char[ROW][COL];
        vis = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            String s = scanner.next();
            map[i] = s.toCharArray();
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (map[i][j] == 't') {
                    dfs(i, j, 0);
                }
            }
        }
        System.out.println(ans);
    }

    static void dfs(int x, int y, int curIndex) {
        //vis[x][y] = 1;
        curIndex++;
        if (curIndex == target.length) {
            ans++;
            return;
        }

        if (x - 1 >= 0 && map[x - 1][y] == target[curIndex]) {
            dfs(x - 1, y, curIndex);
        }
        if (x + 1 < ROW && map[x + 1][y] == target[curIndex]) {
            dfs(x + 1, y, curIndex);
        }
        if (y - 1 >= 0 && map[x][y - 1] == target[curIndex]) {
            dfs(x, y - 1, curIndex);
        }
        if (y + 1 < COL && map[x][y + 1] == target[curIndex]) {
            dfs(x, y + 1, curIndex);
        }

        //vis[x][y] = 0;
    }
}
