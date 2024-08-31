package com.wjm.question.ifly;

import java.util.*;

public class Question02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int opCnt = scanner.nextInt();
        int[][] ops = new int[opCnt][2];
        for (int i = 0; i < opCnt; i++) {
            ops[i][0] = scanner.nextInt();
            ops[i][1] = scanner.nextInt();
        }

        ArrayList<Set<Integer>> map = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            HashSet<Integer> set = new HashSet<>();
            set.add(i - 1);
            map.add(set);
        }

        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            arr.add(i + 1);
        }
        all.add(new ArrayList<>(arr));

        for (int i = 0; i < ops.length; i++) {
            int l = ops[i][0], r = ops[i][1];
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(arr.subList(0, l - 1));
            list.addAll(arr.subList(r, arr.size()));
            list.addAll(arr.subList(l - 1, r));
            all.add(new ArrayList<>(list));
            arr = list;
        }

        for (ArrayList<Integer> list : all) {
            for (int i = 0; i < list.size(); i++) {
                int x = list.get(i);
                map.get(x - 1).add(i);
            }
        }

        for (int i = 0; i < num; i++) {
            if (i == 0) System.out.printf("%d", map.get(i).size());
            else System.out.printf(" %d", map.get(i).size());
        }
        System.out.print("\n");
    }
}
