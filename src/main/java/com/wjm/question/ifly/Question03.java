package com.wjm.question.ifly;

import java.util.*;

public class Question03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int ops = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        char[] ss = s.toCharArray();

        ArrayList<Integer> gap = new ArrayList<>();
        char c = '1';
        int curL = 0;
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == c) {
                curL++;
            } else {
                gap.add(curL);
                idxMap.put(gap.size() - 1, i - 1);
                curL = 1;
                c = ss[i];
            }
        }
        gap.add(curL);
        idxMap.put(gap.size() - 1, ss.length - 1);
        HashMap<Integer, Integer> zero = new HashMap<>();
        for (int i = 0; i < gap.size(); i++) {
            if (i % 2 == 0) continue;
            zero.put(i, gap.get(i));
        }


        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(zero.entrySet());
        entries.sort((o1, o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                Integer k1 = o1.getKey();
                Integer k2 = o2.getKey();

                int a = gap.get(k1 - 1) + o1.getValue() + gap.get(k1 + 1);
                int b = gap.get(k2 - 1) + o2.getValue() + gap.get(k2 + 1);
                return b - a;
            }
            return o1.getValue() - o2.getValue();
        });

        for (Map.Entry<Integer, Integer> entry : entries) {
            int idx = entry.getKey();
            int l = entry.getValue();
            int idx2 = idxMap.get(idx);
            while (ops > 0 && l > 0) {
                ss[idx2] = '1';
                idx2++;
                l--;
                ops--;
            }
        }

        int cur = 0;
        int ans = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '1') cur++;
            else {
                ans += (cur * cur);
                cur = 0;
            }
        }
        ans += (cur * cur);
        System.out.println(ans);
    }
}
