package com.wjm.question.mihoyo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question02 {
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] bonus = new int[m];
        for (int i = 0; i < m; i++) {
            bonus[i] = scanner.nextInt();
        }

        int[][] amount = new int[n][3];
        int[][] from = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                amount[i][j] = scanner.nextInt();
            }
            for (int j = 0; j < 3; j++) {
                from[i][j] = scanner.nextInt();
            }
        }

        int[] choice = new int[n];
        for (int i = 0; i < 3; i++) {
            dfs(choice, 0, from[0][i], from, amount, bonus);
        }
        System.out.println(ans);
    }

    static void dfs(int[] choice, int point, int k, int[][] from, int[][] amount, int[] bonus) {
        if (point >= from.length) {
            int cal = cal(choice, bonus, amount, from);
            if (cal > ans) {
                ans = cal;
                System.out.println(Arrays.toString(choice));
            }
            return;
        }

        choice[point] = k;
        for (int i = 0; i < 3; i++) {
            if (point + 1 < from.length) dfs(choice, point + 1, from[point + 1][i], from, amount, bonus);
            else dfs(choice, point + 1, 0, from, amount, bonus);
        }
    }

    static int cal(int[] choice, int[] bonus, int[][] amount, int[][] from) {
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (int i = 0; i < choice.length; i++) {
            int idx = 0;
            for (int j = 0; j < 3; j++) {
                if (choice[i] == from[i][j]) idx = j;
            }
            ret += amount[i][idx];
            map.merge(choice[i], 1, (oldVal, newVal) -> oldVal + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            if (val >= 3) {
                ret += bonus[key];
            }
        }
        return ret;
    }
}
