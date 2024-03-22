package com.wjm.question.codetop;

import java.util.HashMap;

/**
 * @author stephen wang
 */
public class Question076 {
    public String minWindow(String s, String t) {
        int ansL = 0, ansR = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }
        return "";
    }

}
