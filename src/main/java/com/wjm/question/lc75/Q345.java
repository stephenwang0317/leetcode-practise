package com.wjm.question.lc75;

public class Q345 {
    public String reverseVowels(String s) {
        char[] ss = s.toCharArray();
        int l = 0, r = ss.length - 1;
        while (l < r && !isOk(ss[r])) r--;
        while (l < r) {
            while (l < r && !isOk(ss[l])) l++;
            char t = ss[l];
            if (l < r) {
                ss[l] = ss[r];
                ss[r] = t;
                l++;
                r--;
            }
            while (l < r && !isOk(ss[r])) r--;
        }
        return String.copyValueOf(ss);
    }

    boolean isOk(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        Q345 q05 = new Q345();
        System.out.println(q05.reverseVowels("leetcode"));
    }
}
