package com.wjm.question.hwexam;

import com.wjm.utils.InputConverter;
import javafx.util.Pair;

import java.util.*;

public class DelayTime2 {

        ArrayList<HashMap<Integer, Integer>> map;
        int[] vis;
        int[] dist;
        PriorityQueue<Pair<Integer, Integer>> q;

        public int networkDelayTime(int[][] times, int n, int k) {
            map = new ArrayList<>();
            vis = new int[n];
            dist = new int[n];
            Arrays.fill(dist, 1000);
            q = new PriorityQueue<>((a, b) ->
                    Objects.equals(a.getValue(), b.getValue()) ?
                            a.getKey() - b.getKey() : a.getValue() - b.getValue());
            for (int i = 0; i < n; i++) {
                map.add(new HashMap<>());
            }
            for (int[] ints : times) {
                int x = ints[0] - 1, y = ints[1] - 1, time = ints[2];
                map.get(x).put(y, time);
            }
            Arrays.fill(dist, 1000);
            q.offer(new Pair<>(k - 1, 0));
            dist[k - 1] = 0;
            bfs(q);

            int ans = Arrays.stream(dist).max().getAsInt();
            return ans == 1000 ? -1 : ans;
        }

        public void bfs(PriorityQueue<Pair<Integer, Integer>> q) {

            while (!q.isEmpty()) {
                Pair<Integer, Integer> poll = q.poll();
                Integer x = poll.getKey();
                Integer y = poll.getValue();
                HashMap<Integer, Integer> map1 = map.get(x);
                for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                    Integer to = entry.getKey();
                    Integer len = entry.getValue();
                    int t = dist[x] + len;
                    if (t < dist[to]) {
                        dist[to] = t;
                        q.offer(new Pair<>(to, t));
                    }
                }
            }
        }

    public static void main(String[] args) {
        DelayTime2 delayTime2 = new DelayTime2();
        int[][] ints = InputConverter.stringToIntArray("[[2,1,1],[2,3,1],[3,4,1]]");
        delayTime2.networkDelayTime(ints,4,2);
    }
}
