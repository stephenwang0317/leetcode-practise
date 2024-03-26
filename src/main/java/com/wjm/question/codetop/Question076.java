package com.wjm.question.codetop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author stephen wang
 */
public class Question076 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int ansL = 0, ansR = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i), 1, (old, neww) -> old + 1);
        }

        int l = 0, r = 0;
        for (; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                map.computeIfPresent(s.charAt(r), (k, v) -> v - 1);
                while (check(map) && l <= r) {
                    if (r - l < ansR - ansL) {
                        ansR = r;
                        ansL = l;
                    }
                    map.computeIfPresent(s.charAt(l), (k, v) -> v + 1);
                    l++;
                }
            }
        }
        if (ansR == Integer.MAX_VALUE) return "";
        return s.substring(ansL, ansR + 1);
    }

    boolean check(HashMap<Character, Integer> map) {
        boolean f = true;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                f = false;
                break;
            }
        }
        return f;
    }

    public static void main(String[] args) {
        Question076 q = new Question076();
        System.out.println(q.minWindow("aaflslflsldkalskaaa", "aaa"));
    }
}
