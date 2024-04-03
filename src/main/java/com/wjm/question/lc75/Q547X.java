package com.wjm.question.lc75;

import com.wjm.utils.InputConverter;

import java.util.ArrayDeque;

public class Q547X {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    bfs(isConnected, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    void bfs(int[][] maze, int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        maze[i][j] = 2;

        while (!q.isEmpty()) {
            int[] point = q.pollFirst();
            int x = point[0], y = point[1];
            if (x - 1 >= 0 && maze[x - 1][y] == 1) {
                maze[x - 1][y] = 2;
                q.offerLast(new int[]{x - 1, y});
            }
            if (x + 1 < maze.length && maze[x + 1][y] == 1) {
                maze[x + 1][y] = 2;
                q.offerLast(new int[]{x + 1, y});
            }
            if (y - 1 >= 0 && maze[x][y - 1] == 1) {
                maze[x][y - 1] = 2;
                q.offerLast(new int[]{x, y - 1});
            }
            if (y + 1 < maze[0].length && maze[x][y + 1] == 1) {
                maze[x][y + 1] = 2;
                q.offerLast(new int[]{x, y + 1});
            }
        }
    }

    public static void main(String[] args) {
        Q547X q = new Q547X();
        int[][] ints = InputConverter.stringToIntArray("[[1,0,0],[0,1,0],[0,0,1]]");
        System.out.println(q.findCircleNum(ints));
    }
}
