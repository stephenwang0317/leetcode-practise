package com.wjm.question.dji;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Question01 {
    /* Write Code Here */
    public int numberOfPatrolBlocks(int[][] block) {
        int ans = 0;
        int row = block.length, col = block[0].length;
        int[][] vis = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(vis[i], 0);
        }

        int face = 0; // 0-right, 1-down, 2-left, 3-top
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.offerLast(new int[]{0, 0});
        vis[0][0] = 1;
        while (!stack.isEmpty()) {
            int[] o = stack.pollLast();
            int x = o[0], y = o[1];
            System.out.println(x + " " + y);
            if (vis[x][y] == 1) {
                ans++;
            } else if (vis[x][y] > 2) {
                break;
            }

            int tFace = face;
            for (int i = 0; i < 4; i++) {
                if (face == 0) {
                    if (y + 1 < col && block[x][y + 1] == 0) {
                        stack.offerLast(new int[]{x, y + 1});
                        vis[x][y + 1]++;
                        break;
                    } else {
                        face++;
                    }
                } else if (face == 1) {
                    if (x + 1 < row && block[x + 1][y] == 0) {
                        stack.offerLast(new int[]{x + 1, y});
                        vis[x + 1][y]++;
                        break;
                    } else {
                        face++;
                    }
                } else if (face == 2) {
                    if (y - 1 >= 0 && block[x][y - 1] == 0) {
                        stack.offerLast(new int[]{x, y - 1});
                        vis[x][y - 1]++;
                        break;
                    } else {
                        face++;
                    }
                } else if (face == 3) {
                    if (x - 1 >= 0 && block[x - 1][y] == 0) {
                        stack.offerLast(new int[]{x - 1, y});
                        vis[x - 1][y]++;
                        break;
                    } else {
                        face = 0;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int block_rows = 0;
        int block_cols = 0;
        block_rows = in.nextInt();
        block_cols = in.nextInt();

        int[][] block = new int[block_rows][block_cols];
        for (int block_i = 0; block_i < block_rows; block_i++) {
            for (int block_j = 0; block_j < block_cols; block_j++) {
                block[block_i][block_j] = in.nextInt();
            }
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }


        res = new Question01().numberOfPatrolBlocks(block);
        System.out.println(String.valueOf(res));
    }
}
