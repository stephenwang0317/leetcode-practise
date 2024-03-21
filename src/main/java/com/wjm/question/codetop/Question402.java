package com.wjm.question.codetop;

import java.util.ArrayDeque;

/**
 * @author stephen wang
 */
public class Question402 {
    public String removeKdigits(String num, int k) {
        ArrayDeque<Character> q = new ArrayDeque<>();
        char[] charArray = num.toCharArray();
        q.push(charArray[0]);
        int cnt = 0;
        for (int i = 1; i < charArray.length; i++) {
            if (cnt < k) {
                int top = q.peek().charValue() - '0';
                if (top < charArray[i] - '0') {
                    q.push(charArray[i]);
                } else {
                    while (!q.isEmpty() && cnt < k && q.peek().charValue() - '0' >= charArray[i] - '0') {
                        q.pop();
                        cnt++;
                    }
                    q.push(charArray[i]);
                }
            } else {
                q.push(charArray[i]);
            }
        }
        while (cnt < k) {
            q.pop();
            cnt++;
        }
        StringBuilder sb = new StringBuilder("0");
        Character c;
        while ((c = q.pollLast()) != null) {
            sb.append(c);
        }
        String ret = sb.toString().replaceFirst("^0*", "");
        if (ret.isEmpty()) ret = "0";
        return ret;
    }

    public static void main(String[] args) {
        Question402 q = new Question402();
        System.out.println(q.removeKdigits("1", 1));
    }
}
