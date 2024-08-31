package com.wjm.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
 * 两个整数的 数位差 指的是两个整数 相同 位置上不同数字的数目。
 * 请你返回 nums 中 所有 整数对里，数位差之和。
 */
public class Everyday0831 {
    public boolean canMakeSquare(char[][] grid) {
        if (check(grid)) return true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 'B') grid[i][j] = 'W';
                else grid[i][j] = 'B';
                boolean check = check(grid);
                if (check) return true;
                if (grid[i][j] == 'B') grid[i][j] = 'W';
                else grid[i][j] = 'B';
            }
        }
        return false;
    }

    boolean check(char[][] grid) {
        for (int i = 0; i < 4; i++) {
            int row = i / 2;
            int col = i % 2;
            if (grid[row][col] == grid[row + 1][col]
                    && grid[row][col] == grid[row][col + 1]
                    && grid[row][col] == grid[row + 1][col + 1]) {
                return true;
            }
        }
        return false;
    }
}
