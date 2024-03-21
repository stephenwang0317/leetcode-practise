package com.wjm.question.codetop;

import com.wjm.utils.InputConverter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author stephen wang
 */
public class Question200 {
    int cnt, m, n;

    public int numIslands(char[][] grid) {
        this.cnt = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    fun(grid, i, j);
                }
            }
        }
        return this.cnt;
    }

    void fun(char[][] nums, int x, int y) {
        this.cnt++;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        nums[x][y] = '2';

        while (!q.isEmpty()) {
            int[] t = q.poll();
            int i = t[0], j = t[1];

            if (i < m - 1 && nums[i + 1][j] == '1') {
                q.add(new int[]{i + 1, j});
                nums[i + 1][j] = '2';
            }
            if (i > 0 && nums[i - 1][j] == '1') {
                q.add(new int[]{i - 1, j});
                nums[i - 1][j] = '2';
            }

            if (j < n - 1 && nums[i][j + 1] == '1') {
                q.add(new int[]{i, j + 1});
                nums[i][j + 1] = 1;
            }
            if (j > 0 && nums[i][j - 1] == '1') {
                q.add(new int[]{i, j - 1});
                nums[i][j - 1] = 1;
            }
        }
    }

}
