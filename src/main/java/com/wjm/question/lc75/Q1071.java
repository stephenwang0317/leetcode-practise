package com.wjm.question.lc75;

public class Q1071 {
    public String gcdOfStrings(String str1, String str2) {
        int x = gcd(str1.length(), str2.length());
        if ((str1 + str2).equals(str2 + str1))
            return str1.substring(0, x + 1);
        else
            return "";
    }

    int gcd(int a, int b) {
        int r = a % b;
        if (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }
}
