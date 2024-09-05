package com.wjm.everyday;

import java.util.ArrayDeque;

public class Everyday0905 {
    public String clearDigits(String s) {
        char[] ss = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] >= '0' && ss[i] <= '9') {
                if (!stack.isEmpty()) stack.pollLast();
            } else {
                stack.offerLast(ss[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Everyday0905 q = new Everyday0905();
        System.out.println(q.clearDigits("cb34"));
    }
}
