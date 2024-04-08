package com.wjm.question.hwexam;

public class SearchWord {
    char[][] map;
    int[][] vis;
    char[] target;
    boolean ans = false;
    int ROW, COL;

    public boolean exist(char[][] board, String word) {
        this.map = board;
        this.target = word.toCharArray();
        ROW = map.length;
        COL = map[0].length;
        vis = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (board[i][j] == target[0] && !ans) {
                    dfs(i, j, 0);
                }
            }
        }
        return ans;
    }

    void dfs(int x, int y, int curIndex) {
        if (ans) return;
        vis[x][y] = 1;
        curIndex++;
        if (curIndex == target.length) {
            ans = true;
            return;
        }

        if (x - 1 >= 0 && vis[x - 1][y] == 0 && map[x - 1][y] == target[curIndex]) {
            dfs(x - 1, y, curIndex);
        }
        if (x + 1 < ROW && vis[x + 1][y] == 0 && map[x + 1][y] == target[curIndex]) {
            dfs(x + 1, y, curIndex);
        }
        if (y - 1 >= 0 && vis[x][y - 1] == 0 && map[x][y - 1] == target[curIndex]) {
            dfs(x, y - 1, curIndex);
        }
        if (y + 1 < COL && vis[x][y + 1] == 0 && map[x][y + 1] == target[curIndex]) {
            dfs(x, y + 1, curIndex);
        }

        vis[x][y] = 0;
    }
}
