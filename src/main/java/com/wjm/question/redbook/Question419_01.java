package com.wjm.question.redbook;

import java.util.*;

public class Question419_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        ArrayList<int[]> notes = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int[] t = new int[2];
            t[0] = scanner.nextInt();
            notes.add(t);
        }
        for (int i = 0; i < n; i++) {
            int[] ints = notes.get(i);
            ints[1] = scanner.nextInt();
        }
        Collections.sort(notes, (a, b) -> {
            if (b[1] != a[1]) {
                return b[1] - a[1];
            } else return b[0] - a[0];
        });
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o1 - o2);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            int t = notes.get(i)[0];
            q.offer(t);
            sum += t;
        }
        int cur = sum * notes.get(k - 1)[1];
        for (int i = k; i < n; i++) {
            int t = notes.get(i)[0];
            if (t <= q.peek()) continue;
            Integer min = q.poll();
            q.offer(t);
            sum -= min;
            sum += t;
            int mul = sum * notes.get(i)[1];
            if (mul > cur) {
                cur = mul;
            }
        }
        System.out.println(cur);

    }

}
