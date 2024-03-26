package com.wjm.question.lc75;

import com.sun.deploy.util.StringUtils;

public class Q392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length()==0) return true;
        for (int start = 0; start < t.length(); ) {
            while (start < t.length() && t.charAt(start) != s.charAt(0)) start++;
            int j = start;
            int i = 0;
            for (i = 0; i < s.length(); i++) {
                while (j < t.length() && t.charAt(j) != s.charAt(i)) j++;
                if (j == t.length()) break;
                j++;
            }
            if (i == s.length()) return true;
        }
        return false;
    }
}
