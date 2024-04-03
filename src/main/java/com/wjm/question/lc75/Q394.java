package com.wjm.question.lc75;

import java.util.ArrayDeque;

public class Q394 {
    public String decodeString(String s) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        char[] ss = s.toCharArray();
        StringBuilder num = new StringBuilder();
        boolean f = false;
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == ']') {
                String c;
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !(c = stack.pollLast()).equals("[")) {
                    sb.insert(0, c);
                }
                int k = Integer.parseInt(stack.pollLast());
                StringBuilder sb1 = new StringBuilder();
                for (int j = 0; j < k; j++) {
                    sb1.append(sb);
                }
                stack.offerLast(sb1.toString());
            } else {
                if (ss[i] >= '0' && ss[i] <= '9') {
                    num.append(ss[i]);
                } else if (ss[i] == '[') {
                    stack.offerLast(num.toString());
                    num.delete(0, num.length());
                    stack.offerLast("[");
                }else {
                    stack.offerLast(String.valueOf(ss[i]));
                }
            }
        }
        StringBuilder ret = new StringBuilder();
        while (!stack.isEmpty()) {
            ret.append(stack.pollFirst());
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Q394 q = new Q394();
        System.out.println(q.decodeString("3[a2[bc]]"));
    }
}
