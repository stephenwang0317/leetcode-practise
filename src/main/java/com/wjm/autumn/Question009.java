package com.wjm.autumn;

import javafx.print.Collation;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串
 */
public class Question009 {
    public String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        int[][] dp = new int[ss.length][ss.length];
        for (int i = 0; i < ss.length; i++) dp[i][i] = 1;

        for (int i = 1; i < ss.length; i++) {
            int x = 0, y = i;
            for (int j = 0; j < ss.length - i; j++) {
                dp[x][y] = 1;
                if (y - x == 1 && ss[y] == ss[x]) dp[x][y] = 2;
                if (x + 1 <= y - 1 && ss[x] == ss[y] && dp[x + 1][y - 1] == (y - 1) - (x + 1) + 1) {
                    dp[x][y] = Math.max(dp[x][y], dp[x + 1][y - 1] + 2);
                }
                x++;
                y++;
            }
        }

        int x = -1, y = -1, max = -1;
        for (int i = 0; i < ss.length; i++) {
            for (int j = i; j < ss.length; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        return s.substring(x, y + 1);
    }

    public String longestPalindrome2(String s) {
        char[] ss = s.toCharArray();
        int[] dp = new int[ss.length];
        Arrays.fill(dp, 1);
        int ans = Integer.MIN_VALUE, index = -1;
        boolean f = false;
        for (int i = 0; i < ss.length; i++) {
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < ss.length && ss[l] == ss[r]) {
                dp[i] += 2;
                l--;
                r++;
            }
            if (dp[i] > ans) {
                ans = dp[i];
                f = false;
                index = i;
            }
            if (i < ss.length - 1 && ss[i] == ss[i + 1]) {
                int ll = i - 1, rr = i + 2, len = 2;
                while (ll >= 0 && rr < ss.length && ss[ll] == ss[rr]) {
                    len += 2;
                    ll--;
                    rr++;
                }
                if (len > dp[i]) {
                    dp[i] = len;
                    if (dp[i] > ans) {
                        ans = dp[i];
                        f = true;
                        index = i;
                    }
                }
            }
        }
        if (!f) {
            return s.substring(index - (ans - 1) / 2, index + (ans - 1) / 2 + 1);
        } else {
            return s.substring(index - ans / 2 + 1, index + ans / 2 + 1);
        }

    }

    // bb
    /*
        10
        01
     */
    public static void main(String[] args) {
        String s = "ccc";
        Question009 q = new Question009();
        String s1 = q.longestPalindrome2(s);
        System.out.println(s1);
    }
}
// babad
// 01234
//    3