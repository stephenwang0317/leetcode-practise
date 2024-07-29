package com.wjm.question.meituan;

import java.util.*;

public class Test03X {
    static Integer ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        char[] ss = s.toCharArray();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            //String line = scanner.nextLine();
            //String[] split = line.split(" ");
            //int a = Integer.parseInt(split[0]) - 1, b = Integer.parseInt(split[1]) - 1;
            int a = scanner.nextInt()-1,b=scanner.nextInt()-1;
            if (map.containsKey(a)) {
                map.get(a).add(b);
            } else {
                ArrayList<Integer> list = new ArrayList<>(Arrays.asList(b));
                map.put(a, list);
            }
        }
        func(0,map,ss);
        System.out.println(ans);
    }

    static Character func(int index, HashMap<Integer, ArrayList<Integer>> map, char[] ss) {
        if (map.get(index) == null) {
            return ss[index];
        }
        ArrayList<Integer> list = map.get(index);
        Integer a = list.get(0), b = -1;
        if (list.size() > 1) b = list.get(1);
        Character left = ' ', right = ' ';
        left = func(a, map, ss);
        if (b != -1)
            right = func(b, map, ss);
        if (right == 'Y' || left == 'Y') {
            ans++;
            return 'Y';
        }
        Set<Character> set = new HashSet<>();
        set.add(left);
        set.add(right);
        set.add(ss[index]);
        if (set.contains('R') && set.contains('B')) {
            ans++;
            return 'Y';
        }
        return ss[index];
    }
}
