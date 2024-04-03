package com.wjm.question.tencent;

import java.util.ArrayList;
import java.util.Scanner;

public class Question3 {
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static int helpCnt = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        for (int i = 0; i < N; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            map.get(a - 1).add(b - 1);
            map.get(b - 1).add(a - 1);
        }
        int[] vis = new int[N];
        int part = 0;
        ArrayList<Integer> partNum = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                helpCnt = 0;
                dfs(vis, i);
                part++;
                partNum.add(helpCnt);
            }
        }
        if (part > 2) {
            System.out.println(0);
        } else {
            System.out.println(partNum.get(0) * partNum.get(1));
        }
    }

    static void dfs(int[] vis, int index) {
        vis[index] = 1;
        helpCnt++;
        ArrayList<Integer> neighbour = map.get(index);
        for (int k : neighbour) {
            if (vis[k] != 1) {
                dfs(vis, k);
            }
        }
    }

}
