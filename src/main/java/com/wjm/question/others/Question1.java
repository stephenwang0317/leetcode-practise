package com.wjm.question.others;

import java.util.Arrays;

/**
 * 给定一个字符用s和一个整数n，便用s中的字符(不需要全部使用)来生成一个新的字符串newS，要求newS中任意字母
 * 连续出现的次数不超过"，请返回字典序最大的news。
 */
public class Question1 {

    public static String function(String s, int n) {
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        int curLen = 0;
        char curChar = (char) 0;
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            char c = ss[i];
            if (c != curChar) {
                curChar = c;
                sb.append(c);
                curLen = 1;
            } else {
                if (curLen + 1 <= n) {
                    sb.append(c);
                    curLen++;
                } else {
                    continue;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s= "aaabddnnnnnnnxxzzzzzzz";
        System.out.println(function(s,3));
    }
}
