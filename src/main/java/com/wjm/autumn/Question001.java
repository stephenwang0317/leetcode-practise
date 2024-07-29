package com.wjm.autumn;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 *
 * @Author stephen wang
 */
public class Question001 {
    public int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int cur = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < ss.length; i++) {
            char c = ss[i];
            if (!map.containsKey(c)) {
                map.put(c, i);
                cur++;
            } else {


                int k = map.get(c);
                if (i - cur <= k) {
                    if (cur > max) max = cur;
                    cur = i - k;

                } else {
                    cur ++;
                }
                map.put(c,i);

            }
        }
        if (cur > max) max = cur;
        return max;
    }

    public static void main(String[] args) {
        Question001 question001 = new Question001();
        int i = question001.lengthOfLongestSubstring("abba");
        System.out.println(i);

    }
}
