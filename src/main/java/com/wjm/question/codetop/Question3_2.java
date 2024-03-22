package com.wjm.question.codetop;

import java.util.HashMap;

/**
 * @author stephen wang
 */
public class Question3_2 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ss = s.toCharArray();
        int ans = 0;
        int l = 0, r = 0;
        for (int i = 0; i < ss.length; i++) {
            if (!map.containsKey(ss[i])) {
                map.put(ss[i], i);
                r = i;
            } else {
                l = Math.max(l, map.get(ss[i]) + 1);
                map.put(ss[i], i);
                r = i;
            }

            if (r - l + 1 > ans) ans = r - l + 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        Question3_2 m = new Question3_2();
        System.out.println(m.lengthOfLongestSubstring("abcabcbb"));
    }
}
