package com.wjm.question.huawei;

import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int thresh = scanner.nextInt(), N = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        // 0 严重，1 普通
        HashMap<String, int[]> errors = new HashMap<>();
        Set<String> toMap = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            String son = split[0], father = split[1];
            int fatal = Integer.parseInt(split[2]), cnt = Integer.parseInt(split[3]);

            if (!toMap.contains(son)){
                map.merge(father, new ArrayList<>(Arrays.asList(son)), (oldVal, newVal) -> {
                    oldVal.add(son);
                    return oldVal;
                });
                toMap.add(son);
            }

            int[] thisError = new int[]{0, 0};
            thisError[fatal] = cnt;
            errors.merge(son, thisError, (oldVal, newVal) -> {
                oldVal[fatal] += cnt;
                return oldVal;
            });
        }
        int ans = 0;
        ArrayList<String> roots = map.get("*");
        for (String root : roots) {
            int rootDi = calDi(map, errors, root);
            if (rootDi > thresh) ans++;
        }
        System.out.println(ans);
    }

    public static int calDi(HashMap<String, ArrayList<String>> map, HashMap<String, int[]> errors, String root) {
        int[] err = errors.get(root);
        int curDi = err[0] * 5 + err[1] * 2;
        ArrayList<String> children = map.get(root);
        if (children==null){
            return curDi;
        }

        for (String child : children) {
            int childDi = calDi(map, errors, child);
            curDi += childDi;
        }
        return curDi;
    }
}
