package com.wjm.question.mihoyo;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Question03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] grid = new int[rows][cols];
        scanner.nextLine();
        for (int i = 0; i < rows; i++) {
            String s = scanner.nextLine();
            char[] ss = s.toCharArray();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = (ss[j] == '#') ? -1 : 0; // -1 地， 0 海
            }
        }

        int cur = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    bfs(grid, cur, i, j);
                    cur++;
                }
            }
        }

        int ans = -1;
        for (int i = 1; i < cur; i++) {
            int[][] vis = new int[rows][cols];
            loop:
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    if (grid[j][k] == i) {
                        int i1 = bfsCnt(grid, i, j, k, vis);
                        ans = Math.max(ans, i1);
                        break loop;
                    }
                }
            }
        }
        System.out.println(ans);

//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.printf("%d\t", grid[i][j]);
//            }
//            System.out.println();
//        }
    }

    static void bfs(int[][] grid, int cnt, int x, int y) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{x, y});
        grid[x][y] = cnt;
        while (!q.isEmpty()) {
            int[] ints = q.pollFirst();
            int row = ints[0], col = ints[1];

            if (row - 1 >= 0 && grid[row - 1][col] == 0) {
                grid[row - 1][col] = cnt;
                q.offerLast(new int[]{row - 1, col});
            }
            if (row + 1 < grid.length && grid[row + 1][col] == 0) {
                grid[row + 1][col] = cnt;
                q.offerLast(new int[]{row + 1, col});
            }
            if (col - 1 >= 0 && grid[row][col - 1] == 0) {
                grid[row][col - 1] = cnt;
                q.offerLast(new int[]{row, col - 1});
            }
            if (col + 1 < grid[0].length && grid[row][col + 1] == 0) {
                grid[row][col + 1] = cnt;
                q.offerLast(new int[]{row, col + 1});
            }
        }
    }

    static int bfsCnt(int[][] grid, int cnt, int x, int y, int[][] vis) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int ret = 1;
        q.offerLast(new int[]{x, y});
        vis[x][y] = 1;
        while (!q.isEmpty()) {
            int[] ints = q.pollFirst();
            int row = ints[0], col = ints[1];

            if (row - 1 >= 0 && vis[row - 1][col] == 0 && (grid[row - 1][col] == -1 || grid[row - 1][col] == cnt)) {
                ret++;
                vis[row - 1][col] = 1;
                q.offerLast(new int[]{row - 1, col});
            }
            if (row + 1 < grid.length && vis[row + 1][col] == 0 && (grid[row + 1][col] == -1 || grid[row + 1][col] == cnt)) {
                ret++;
                vis[row + 1][col] = 1;
                q.offerLast(new int[]{row + 1, col});
            }
            if (col - 1 >= 0 && vis[row][col - 1] == 0 && (grid[row][col - 1] == -1 || grid[row][col - 1] == cnt)) {
                ret++;
                vis[row][col - 1] = 1;
                q.offerLast(new int[]{row, col - 1});
            }
            if (col + 1 < grid[0].length && vis[row][col + 1] == 0 && (grid[row][col + 1] == -1 || grid[row][col + 1] == cnt)) {
                ret++;
                vis[row][col + 1] = 1;
                q.offerLast(new int[]{row, col + 1});
            }
        }
        return ret;
    }
}
