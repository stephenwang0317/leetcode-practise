package com.wjm.question.lc75;

import com.wjm.utils.InputConverter;

public class Q547 {
    int[][] map;

    public int findCircleNum(int[][] isConnected) {
        int[] vis = new int[isConnected.length];
        int cnt = 0;
        map = isConnected;
        for (int i = 0; i < isConnected.length; i++) {
            if (vis[i] == 0) {
                dfs(vis, i);
                cnt++;
            }
        }
        return cnt;
    }

    void dfs(int[] vis, int num) {
        vis[num] = 1;
        for (int i = 0; i < map[num].length; i++) {
            if (map[num][i] == 1 && vis[i] == 0) {
                dfs(vis, i);
            }
        }
    }

    public static void main(String[] args) {
        Q547 q547 = new Q547();
        int[][] ints = InputConverter.stringToIntArray("[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]");
        System.out.println(q547.findCircleNum(ints));
    }
}
