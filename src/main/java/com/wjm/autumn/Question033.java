package com.wjm.autumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Question033 {
    public int characterReplacement(String s, int k) {
        int max = Integer.MIN_VALUE;
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : ss) {
            set.add(c);
        }

        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            if (!set.contains(c)) continue;
            int l = 0, lSum = 0, rSum = 0;
            for (int r = 0; r < s.length(); r++) {
                rSum += (s.charAt(r) == c ? 0 : 1);
                while (rSum - lSum > k) {
                    lSum += (s.charAt(l) == c) ? 0 : 1;
                    l++;
                }
                max = Math.max(max, r - l + 1);
            }
        }
        return max;
    }
}
