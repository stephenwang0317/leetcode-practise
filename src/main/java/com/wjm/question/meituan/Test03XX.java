package com.wjm.question.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test03XX {
    private static List<List<Integer>> edges = new ArrayList<>();
    private static int cnt = 0;
    private static String str;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        str = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.get(u - 1).add(v - 1);
        }
        dfs(0);
        System.out.println(cnt);
    }

    private static int dfs(int root) {
        List<Integer> integers = edges.get(root);
        boolean hasRed = false;
        boolean hasBlack = false;
        for (int i = 0; i < integers.size(); i++) {
            Integer child = integers.get(i);
            if (dfs(child) == 1) {
                hasRed = true;
            } else if (dfs(child) == 2) {
                hasBlack = true;
            } else if (dfs(child) == 3) {
                hasRed = true;
                hasBlack = true;
            }
        }
        if (hasBlack && hasRed) {
            cnt++;
            return 3;
        }
        if (str.charAt(root) == 'R') {
            hasRed = true;
        } else if (str.charAt(root) == 'B') {
            hasBlack = true;
        }
        if (hasRed && hasBlack) {
            return 3;
        }
        if (hasRed) {
            return 1;
        }
        if (hasBlack) {
            return 2;
        }
        return str.charAt(root) == 'R' ? 1 : 2;
    }
}