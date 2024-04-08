package com.wjm.question.hwexam;

public class Q200 {
    int cnt = 0;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void dfs(char[][] map, int x, int y) {
        int ROW = map.length, COL = map[0].length;
        map[x][y] = '2';
        if (x - 1 >= 0 && map[x - 1][y] == '1') {
            dfs(map, x - 1, y);
        }
        if (x + 1 < ROW && map[x + 1][y] == '1') {
            dfs(map, x + 1, y);
        }
        if (y - 1 >= 0 && map[x][y - 1] == '1') {
            dfs(map, x, y - 1);
        }
        if (y + 1 < COL && map[x][y + 1] == '1') {
            dfs(map, x, y + 1);
        }
    }
}
