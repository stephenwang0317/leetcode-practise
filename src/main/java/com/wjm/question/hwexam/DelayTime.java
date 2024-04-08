package com.wjm.question.hwexam;

import com.wjm.utils.InputConverter;

import java.util.*;

public class DelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] map = new int[n][n];
        int[] dist = new int[n];
        Arrays.fill(dist, 1000);
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], 1000);
        }
        for (int i = 0; i < times.length; i++) {
            int x = times[i][0] - 1, y = times[i][1] - 1, t = times[i][2];
            map[x][y] = t;
        }
        dist[k - 1] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        q.offer(new int[]{k - 1, 0});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0], y = poll[1];

            for (int i = 0; i < n; i++) {
                int t = y + map[x][i];
                if (t < dist[i]) {
                    dist[i] = t;
                    q.offer(new int[]{i, t});
                }
            }
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == 1000 ? -1 : ans;

    }
}
