package com.wjm.question.lc75;

import com.wjm.utils.InputConverter;

import java.util.ArrayDeque;

public class Q1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int length = 0;
        int[][] vis = new int[maze.length][maze[0].length];
        vis[entrance[0]][entrance[1]] = 1;
        q.offerLast(entrance);
        while (!q.isEmpty()) {
            int[] point = q.pollFirst();
            int x = point[0], y = point[1];
            if (x - 1 >= 0 && maze[x - 1][y] == '.' && vis[x - 1][y] == 0) {
                if (x - 1 == 0 || y == maze[0].length - 1 || y == 0)
                    return vis[x][y];
                vis[x - 1][y] = vis[x][y] + 1;
                q.offerLast(new int[]{x - 1, y});
            }
            if (x + 1 < maze.length && maze[x + 1][y] == '.' && vis[x + 1][y] == 0) {
                if (x + 1 == maze.length - 1 || y == maze[0].length - 1 || y == 0)
                    return vis[x][y];
                vis[x + 1][y] = vis[x][y] + 1;
                q.offerLast(new int[]{x + 1, y});
            }
            if (y - 1 >= 0 && maze[x][y - 1] == '.' && vis[x][y - 1] == 0) {
                if (y - 1 == 0 || x == 0 || x == maze.length - 1)
                    return vis[x][y];
                vis[x][y - 1] = vis[x][y] + 1;
                q.offerLast(new int[]{x, y - 1});
            }
            if (y + 1 < maze[0].length && maze[x][y + 1] == '.' && vis[x][y + 1] == 0) {
                if (y + 1 == maze[0].length - 1 || x == 0 || x == maze.length - 1)
                    return vis[x][y];
                vis[x][y + 1] = vis[x][y] + 1;
                q.offerLast(new int[]{x, y + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] chars = InputConverter.stringToCharArray(
                "[[\".\",\"+\",\"+\",\"+\",\"+\"],[\".\",\"+\",\".\",\".\",\".\"]," +
                        "[\".\",\"+\",\".\",\"+\",\".\"]," +
                        "[\".\",\".\",\".\",\"+\",\".\"],[\"+\",\"+\",\"+\",\"+\",\".\"]]"
        );
        Q1926 q = new Q1926();
        System.out.println(q.nearestExit(chars, new int[]{0, 0}));
    }
}
