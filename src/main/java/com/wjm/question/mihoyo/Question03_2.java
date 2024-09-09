package com.wjm.question.mihoyo;

import java.util.*;

public class Question03_2 {

    static class Node {
        int type;
        int id;
        int size;

        public Node(int type, int id) {
            this.type = type;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        Node[][] grid = new Node[rows][cols];
        scanner.nextLine();
        for (int i = 0; i < rows; i++) {
            String s = scanner.nextLine();
            char[] ss = s.toCharArray();
            for (int j = 0; j < cols; j++) {
                if (ss[j] == '#') {
                    grid[i][j] = new Node(1, 0);
                } else {
                    grid[i][j] = new Node(0, 0);
                }
            }
        }

        int id = 0;
        int[][] vis = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j].type == 1 && vis[i][j] == 0) {
                    bfsCnt(grid, id, i, j, vis);
                    id++;
                }
            }
        }

        int ans = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j].type == 1) continue;
                if (vis[i][j] == 1) continue;

                int tmp = 1;
                ArrayDeque<int[]> q = new ArrayDeque<>();
                q.offerLast(new int[]{i, j});
                vis[i][j] = 1;
                Set<Integer> visIds = new HashSet<>();
                while (!q.isEmpty()) {
                    int[] ints = q.pollFirst();
                    int row = ints[0], col = ints[1];
                    if (row - 1 >= 0) {
                        if (grid[row - 1][col].type == 1) {
                            if (!visIds.contains(grid[row - 1][col].id)) {
                                tmp += grid[row - 1][col].size;
                                visIds.add(grid[row - 1][col].id);
                            }
                        } else {
                            if (vis[row - 1][col] == 0) {
                                tmp++;
                                vis[row - 1][col] = 1;
                                q.offerLast(new int[]{row - 1, col});
                            }
                        }
                    }
                    if (row + 1 < grid.length) {
                        if (grid[row + 1][col].type == 1) {
                            if (!visIds.contains(grid[row + 1][col].id)) {
                                tmp += grid[row + 1][col].size;
                                visIds.add(grid[row + 1][col].id);
                            }
                        } else {
                            if (vis[row + 1][col] == 0) {
                                tmp++;
                                vis[row + 1][col] = 1;
                                q.offerLast(new int[]{row + 1, col});
                            }
                        }
                    }
                    if (col - 1 >= 0) {
                        if (grid[row][col - 1].type == 1) {
                            if (!visIds.contains(grid[row][col - 1].id)) {
                                tmp += grid[row][col - 1].size;
                                visIds.add(grid[row][col - 1].id);
                            }
                        } else {
                            if (vis[row][col - 1] == 0) {
                                tmp++;
                                vis[row][col - 1] = 1;
                                q.offerLast(new int[]{row, col - 1});
                            }
                        }
                    }
                    if (col + 1 < grid[0].length) {
                        if (grid[row][col + 1].type == 1) {
                            if (!visIds.contains(grid[row][col + 1].id)) {
                                tmp += grid[row][col + 1].size;
                                visIds.add(grid[row][col + 1].id);
                            }
                        } else {
                            if (vis[row][col + 1] == 0) {
                                tmp++;
                                vis[row][col + 1] = 1;
                                q.offerLast(new int[]{row, col + 1});
                            }
                        }
                    }
                }
                ans = Math.max(ans, tmp);
            }

        }

        System.out.println(ans);

    }

    static int bfsCnt(Node[][] grid, int id, int x, int y, int[][] vis) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int ret = 1;
        ArrayList<int[]> store = new ArrayList<>();
        store.add(new int[]{x, y});
        q.offerLast(new int[]{x, y});
        vis[x][y] = 1;
        while (!q.isEmpty()) {
            int[] ints = q.pollFirst();
            int row = ints[0], col = ints[1];

            if (row - 1 >= 0 && vis[row - 1][col] == 0 && grid[row - 1][col].type == 1) {
                ret++;
                vis[row - 1][col] = 1;
                q.offerLast(new int[]{row - 1, col});
                store.add(new int[]{row - 1, col});
            }
            if (row + 1 < grid.length && vis[row + 1][col] == 0 && grid[row + 1][col].type == 1) {
                ret++;
                vis[row + 1][col] = 1;
                q.offerLast(new int[]{row + 1, col});
                store.add(new int[]{row + 1, col});
            }
            if (col - 1 >= 0 && vis[row][col - 1] == 0 && grid[row][col - 1].type == 1) {
                ret++;
                vis[row][col - 1] = 1;
                q.offerLast(new int[]{row, col - 1});
                store.add(new int[]{row, col - 1});
            }
            if (col + 1 < grid[0].length && vis[row][col + 1] == 0 && grid[row][col + 1].type == 1) {
                ret++;
                vis[row][col + 1] = 1;
                q.offerLast(new int[]{row, col + 1});
                store.add(new int[]{row, col + 1});
            }
        }
        for (int[] ints : store) {
            int a = ints[0], b = ints[1];
            grid[a][b].id = id;
            grid[a][b].size = ret;
        }

        return ret;
    }
}
