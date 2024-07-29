package com.wjm.question.huawei;


import java.util.*;

public class Question3 {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        //HashMap<Integer, ArrayList<Pair<Integer, Integer>>> map = new HashMap<>();
        //for (int i = 0; i < n; i++) {
        //    ArrayList<Pair<Integer, Integer>> val = new ArrayList<>();
        //    for (int j = 0; j < n; j++) {
        //        int distance = scanner.nextInt();
        //        if (distance == -1) continue;
        //
        //        Pair<Integer, Integer> pair = new Pair<>(j, distance);
        //        val.add(pair);
        //    }
        //    map.put(i, val);
        //}
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        int[] remainingCapacity = new int[n];
        for (int i = 0; i < n; i++) {
            remainingCapacity[i] = scanner.nextInt();
        }
        int faultyNode = scanner.nextInt();
        int sum = scanner.nextInt();

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dijkstra(map, dis, faultyNode);

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
            return dis[a] - dis[b];
        });

        for (int i = 0; i < n; i++) {
            if (i == faultyNode) continue;
            q.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n && sum > 0; i++) {
            Integer poll = q.poll();
            ans.add(poll);
            sum -= remainingCapacity[poll];
        }

        for (int i = 0; i < ans.size(); i++) {
            if (i == 0) System.out.print(ans.get(i));
            else System.out.print(" " + ans.get(i));
        }
    }

    static void dijkstra(int[][] map, int[] dis, int start) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            int lenA = map[a[0]][a[1]];
            int lenB = map[b[0]][b[1]];
            return lenA - lenB;
        });
        dis[start] = 0;
        int[] pre = new int[n];
        Arrays.fill(pre, -1);
        for (int i = 0; i < n; i++) {
            if (map[start][i] != -1) {
                q.add(new int[]{start, i});
            }
        }
        for (; !q.isEmpty(); ) {
            int[] poll = q.poll();
            int from = poll[0], to = poll[1];
            if (dis[to] > dis[from] + map[from][to]) {
                pre[to] = from;
                dis[to] = dis[from] + map[from][to];
            }

            for (int j = 0; j < n; j++) {
                if (map[to][j] != -1 && j != pre[to] && pre[j] == -1) {
                    q.add(new int[]{to, j});
                }
            }
        }
    }

}
