package com.wjm.autumn;

import java.util.Arrays;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的 回文子串。
 */
public class Question024 {
    public String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        boolean[][] dp = new boolean[ss.length][ss.length];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, false));

        for (int i = 0; i < ss.length; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < ss.length; i++) {
            if (i + 1 < ss.length && ss[i] == ss[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        for (int i = 2; i < ss.length - 1; i++) {
            for (int j = 0; j < ss.length - i; j++) {
                dp[j][j + i] = dp[j + 1][j + i - 1] && (ss[j] == ss[j + i]);
            }
        }

        int maxI = 0, maxJ = 0;
        for (int i = 0; i < ss.length; i++) {
            for (int j = 0; j < ss.length; j++) {
                if (dp[i][j] && j - i > maxJ - maxI) {
                    maxJ = j;
                    maxI = i;
                }
            }
        }
        return s.substring(maxI, maxJ + 1);
    }

    public static void main(String[] args) {
        Question024 q = new Question024();
        String s = q.longestPalindrome("ccc");
    }
}
