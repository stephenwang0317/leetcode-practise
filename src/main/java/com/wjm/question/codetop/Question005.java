package com.wjm.question.codetop;

/*
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * */

import java.util.Arrays;

/**
 * @author stephen wang
 */
public class Question005 {
    public String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        boolean[][] map = new boolean[ss.length][ss.length];
        for (boolean[] booleans : map) {
            Arrays.fill(booleans, false);
        }

        for (int i = 0; i < ss.length; i++) {
            map[i][i] = true;
        }
        for (int i = 0; i < ss.length - 1; i++) {
            map[i][i + 1] = (ss[i] == ss[i + 1]);
        }
        for (int x = 2; x < ss.length; x++) {
            for (int i = 0; i < ss.length; i++) {

                if (i + x < ss.length) {
                    map[i][i + x] = map[i + 1][i + x - 1] && (ss[i] == ss[i + x]);
                } else {
                    break;
                }

            }
        }
        int maxI = 0, maxJ = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j]) {
                    if (j - i + 1 > maxJ - maxI + 1) {
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        return s.substring(maxI, maxJ + 1);
    }

    public static void main(String[] args) {
        String a = "aaaaa";
        Question005 q = new Question005();
        System.out.println(q.longestPalindrome(a));
    }
}
