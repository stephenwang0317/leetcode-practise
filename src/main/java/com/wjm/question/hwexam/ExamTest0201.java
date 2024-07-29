package com.wjm.question.hwexam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ExamTest0201 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        TreeMap<String, HashMap<String, Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(",");
            HashMap<String, Integer> map1 = new HashMap<>();
            map1.put(split[2], Integer.parseInt(split[3]));
            map.merge(split[1], map1, (oldVal, newVal) -> {
                oldVal.merge(split[2], Integer.parseInt(split[3]), Integer::sum);
                return oldVal;
            });
        }
        HashMap<String, Integer> factor = new HashMap<>();
        int m = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(",");
            factor.put(split[0], Integer.parseInt(split[1]));
        }
        for (Map.Entry<String, HashMap<String, Integer>> mapEntry : map.entrySet()) {
            String username = mapEntry.getKey();
            HashMap<String, Integer> usedFactors = mapEntry.getValue();
            int cost = 0;
            for (Map.Entry<String, Integer> innerEntry : usedFactors.entrySet()) {
                String factorName = innerEntry.getKey();
                Integer factorNum = innerEntry.getValue();
                cost += factorNum * factor.get(factorName);
            }
            System.out.println(username + "," + cost);
        }
    }
}
