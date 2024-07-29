package com.wjm.question.hwexam;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ExamTest02 {
    static int function(int[][] map, int originalX, int originalY, Set<Integer> relations) {
        int ROW = map.length, COL = map[0].length;
        int[][] vis = new int[ROW][COL];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{originalX, originalY});
        vis[originalX][originalY] = 1;
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] ints = q.pollFirst();
            int x = ints[0], y = ints[1];

            if (x - 1 >= 0 && relations.contains(map[x - 1][y]) && vis[x - 1][y] == 0) {
                vis[x - 1][y] = 1;
                q.offerLast(new int[]{x - 1, y});
                cnt++;
            }

            if (x + 1 < ROW && relations.contains(map[x + 1][y]) && vis[x + 1][y] == 0) {
                vis[x + 1][y] = 1;
                q.offerLast(new int[]{x + 1, y});
                cnt++;
            }

            if (y - 1 >= 0 && relations.contains(map[x][y - 1]) && vis[x][y - 1] == 0) {
                vis[x][y - 1] = 1;
                q.offerLast(new int[]{x, y - 1});
                cnt++;
            }
            if (y + 1 < COL && relations.contains(map[x][y + 1]) && vis[x][y + 1] == 0) {
                vis[x][y + 1] = 1;
                q.offerLast(new int[]{x, y + 1});
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ROW = scanner.nextInt(), COL = scanner.nextInt();
        int[][] ints = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                ints[i][j] = scanner.nextInt();
            }
        }
        int originalX = scanner.nextInt(), originalY = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        HashSet<Integer> set = new HashSet<>();
        for (String s1 : split) {
            set.add(Integer.parseInt(s1));
        }

        System.out.println(function(ints, originalX, originalY, set));
    }
}
