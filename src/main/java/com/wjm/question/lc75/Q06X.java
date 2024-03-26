package com.wjm.question.lc75;

public class Q06X {
    public String reverseWords(String s) {
        char[] ss = s.toCharArray();
        int left = 0, right = ss.length - 1;
        while (ss[left] == ' ') left++;
        while (ss[right] == ' ') right--;
        StringBuilder sb = new StringBuilder();
        for (int i = left; i < right; i++) {
            int l = i;
            while (i < right && ss[i] != ' ')
                i++;
            subFunc(ss, l, i - 1);
            for (int j = l; j < i; j++) sb.append(ss[j]);
            if (i != right) sb.append(' ');
        }
        return sb.toString();
    }

    void subFunc(char[] ss, int l, int r) {
        for (int i = 0; i < (r - l) / 2; i++) {
            char t = ss[l + i];
            ss[l + i] = ss[r - i];
            ss[r - i] = t;
        }
    }

}
