package com.wjm.autumn;

import java.util.Arrays;
import java.util.HashMap;

public class Question029 {
    public int minimumSubstringsInPartition(String s) {
        char[] ss = s.toCharArray();
        int[] dp = new int[ss.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        for (int i = 1; i < ss.length; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            map.put(ss[i], 1);
            for (int j = i - 1; j > 0; j--) {
                map.merge(ss[j], 1, (oldV, newV) -> oldV + 1);
                {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Question029 q = new Question029();
        int i = q.minimumSubstringsInPartition("ababcc");
        System.out.println(i);
    }
}
