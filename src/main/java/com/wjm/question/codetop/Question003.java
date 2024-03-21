package com.wjm.question.codetop;

import java.util.HashMap;

/**
 * @author stephen wang
 */
public class Question003 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int curLength = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ss = s.toCharArray();
        int l = 0, r = 1;
        map.put(ss[0], 0);
        while (r < ss.length) {
            if (map.containsKey(ss[r])) {
                int length = r - l;
                if (length > maxLength) {
                    maxLength = length;
                }
                int newL = map.get(ss[r]) + 1;
                for (int j = l; j < newL; j++) {
                    map.remove(ss[j]);
                }
                l = newL;
                map.put(ss[l], l);
                map.put(ss[r], r);
                r++;
            } else {
                map.put(ss[r], r);
                r++;
            }

        }
        int length = r - l;
        if (length > maxLength) {
            maxLength = length;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int curLength = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ss = s.toCharArray();
        int l = 0, r = 1;
        map.put(ss[0], 0);
        while (r < ss.length) {
            if (map.containsKey(ss[r])) {
                l = Math.max(l, map.get(ss[r]) + 1);
            }
            map.put(ss[r], r);
            r++;
            int length = r - l;
            if (length > maxLength) {
                maxLength = length;
            }
        }
        int length = r - l;
        if (length > maxLength) {
            maxLength = length;
        }
        return maxLength;
    }


    public static void main(String[] args) {
        Question003 codeTop001 = new Question003();
        System.out.println(codeTop001.lengthOfLongestSubstring2("kdvdkf"));
        System.out.println(codeTop001.lengthOfLongestSubstring2("abcabcbb")); // 3
        System.out.println(codeTop001.lengthOfLongestSubstring2("au")); //2
        System.out.println(codeTop001.lengthOfLongestSubstring2(" ")); //1
        System.out.println(codeTop001.lengthOfLongestSubstring2("pwwkew")); //3
        System.out.println(codeTop001.lengthOfLongestSubstring2("dvdf")); //3
    }
}
