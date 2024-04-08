package com.wjm.question.hwexam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class NextTime {
    ArrayList<String> all = new ArrayList<>();
    Integer[] nums;
    String curT;
    int curPos;

    String nextTime(String curTime) {
        Set<Integer> set = new TreeSet<>();
        char[] charArray = curTime.toCharArray();
        StringBuilder ori = new StringBuilder();
        for (char c : charArray) {
            if (c != ':') {
                set.add(c - '0');
                ori.append(c);
            }
        }
        curT = ori.toString();
        nums = set.toArray(new Integer[0]);
        dfs(0, new StringBuilder());
        int target = (curPos == all.size()) ? 0 : curPos;
        StringBuilder stringBuilder = new StringBuilder();
        char[] x = all.get(target).toCharArray();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(x[i]);
            if (i == 1) {
                stringBuilder.append(":");
            }
        }
        all.clear();
        return stringBuilder.toString();
    }

    void dfs(int bit, StringBuilder sb) {
        if (bit == 4) {
            String newT = sb.toString();
            all.add(newT);
            if (newT.equals(curT)) {
                curPos = all.size();
            }
            return;
        }

        if (bit == 0) {
            for (Integer num : nums) {
                if (num > 2) {
                    continue;
                }
                sb.append(num);
                dfs(bit + 1, sb);
                sb.deleteCharAt(bit);
            }
        }

        if (bit == 1) {
            int max = sb.charAt(0) - '0' == 2 ? 4 : 9;
            for (Integer num : nums) {
                if (num > max) continue;
                sb.append(num);
                dfs(bit + 1, sb);
                sb.deleteCharAt(bit);
            }
        }

        if (bit == 2) {
            for (Integer num : nums) {
                if (num > 5) continue;
                sb.append(num);
                dfs(bit + 1, sb);
                sb.deleteCharAt(bit);
            }
        }

        if (bit == 3) {
            for (Integer num : nums) {
                sb.append(num);
                dfs(bit + 1, sb);
                sb.deleteCharAt(bit);
            }
        }
    }

    public static void main(String[] args) {
        NextTime nt = new NextTime();
        //System.out.println(nt.nextTime("19:34"));
        System.out.println(nt.nextTime("20:12"));
        System.out.println(nt.nextTime("23:59"));
        System.out.println(nt.nextTime("12:58"));
        System.out.println(nt.nextTime("18:52"));
        System.out.println(nt.nextTime("23:52"));
        System.out.println(nt.nextTime("09:17"));
        System.out.println(nt.nextTime("07:08"));

    }
}
