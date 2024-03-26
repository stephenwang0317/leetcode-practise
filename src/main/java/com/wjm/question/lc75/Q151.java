package com.wjm.question.lc75;

import java.util.ArrayList;

public class Q151 {
    public String reverseWords(String s) {
        char[] ss = s.toCharArray();
        int left = 0, right = ss.length - 1;
        while (ss[left] == ' ') left++;
        while (ss[right] == ' ') right--;
        ArrayList<String> temp = new ArrayList<>();

        for (int i = left; i <= right; ) {
            StringBuilder sb = new StringBuilder();
            int l = i;
            while (i <= right && ss[i] != ' ')
                i++;
            for (int j = l; j < i; j++) sb.append(ss[j]);
            temp.add(sb.toString());
            while (ss[i] == ' ') i++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = temp.size() - 1; i >= 0; i--) {
            sb.append(temp.get(i));
            if (i != 0)
                sb.append(" ");
        }
        return sb.toString();
    }

}
