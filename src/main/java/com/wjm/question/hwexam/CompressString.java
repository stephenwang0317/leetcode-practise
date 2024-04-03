package com.wjm.question.hwexam;

public class CompressString {
    public String compressString(String S) {
        if (S.length()==0) return S;
        char[] ss = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        char cur = ss[0];
        int cnt = 0;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == cur) cnt++;
            else {
                sb.append(cur).append(cnt);
                cur = ss[i];
                cnt = 1;
            }
        }
        sb.append(cur).append(cnt);
        return sb.length() > ss.length ? S : sb.toString();
    }
}
