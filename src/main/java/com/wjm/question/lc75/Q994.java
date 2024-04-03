package com.wjm.question.lc75;

import com.wjm.utils.InputConverter;

import java.util.*;

public class Q994 {
    int[][] vis;
    int[][] maze;

    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        maze = grid;
        int M = grid.length - 1, N = grid[0].length - 1;

        vis = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 1;
                    q.offerLast(new int[]{i, j});
                    bfs(q);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) return -1;
                max = Math.max(max, vis[i][j]);
            }
        }
        return Math.max(0, max - 1);
    }

    void bfs(ArrayDeque<int[]> q) {
        while (!q.isEmpty()) {
            int[] point = q.pollFirst();
            int x = point[0], y = point[1];
            if (x - 1 >= 0 && maze[x - 1][y] == 1 && (vis[x - 1][y] == 0 || vis[x - 1][y] > vis[x][y] + 1)) {
                vis[x - 1][y] = vis[x][y] + 1;
                q.offerLast(new int[]{x - 1, y});
            }
            if (x + 1 < maze.length && maze[x + 1][y] == 1 && (vis[x + 1][y] == 0 || vis[x + 1][y] > vis[x][y] + 1)) {
                vis[x + 1][y] = vis[x][y] + 1;
                q.offerLast(new int[]{x + 1, y});
            }
            if (y - 1 >= 0 && maze[x][y - 1] == 1 && (vis[x][y-1] == 0 || vis[x][y - 1] > vis[x][y] + 1)) {
                vis[x][y - 1] = vis[x][y] + 1;
                q.offerLast(new int[]{x, y - 1});
            }
            if (y + 1 < maze[0].length && maze[x][y + 1] == 1 && (vis[x][y+1] == 0 || vis[x][y + 1] > vis[x][y] + 1)) {
                vis[x][y + 1] = vis[x][y] + 1;
                q.offerLast(new int[]{x, y + 1});
            }
        }
    }

    public static void main(String[] args) {
        Q994 q = new Q994();
        int[][] ints = InputConverter.stringToIntArray("[[2,1,1],[1,1,0],[0,1,1]]");
        System.out.println(q.orangesRotting(ints));
    }
}
