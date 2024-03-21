package com.wjm.question.codetop;

import java.util.Arrays;
import java.util.Map;

/**
 * @author stephen wang
 */
public class Question1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] ss1 = text1.toCharArray(), ss2 = text2.toCharArray();
        int[][] map = new int[ss1.length + 1][ss2.length + 1];

        map[0][0] = 0;
        Arrays.fill(map[0], 0);
        for (int i = 1; i < ss1.length + 1; i++) {
            map[i][0] = 0;
        }

        for (int i = 1; i <= ss1.length; i++) {
            for (int j = 1; j <= ss2.length; j++) {
                if (ss1[i - 1] == ss2[j - 1]) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                } else {
                    map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                }
            }
        }
        return map[ss1.length][ss2.length];
    }
}
