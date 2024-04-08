package com.wjm.question.hwexam;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Q227 {
    public int calculate(String s) {
        char[] ss = s.toCharArray();
        ArrayList<String> suffix = new ArrayList<>();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        boolean num = false;
        int curNum = 0;
        for (char c : ss) {
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                if (num) {
                    curNum = curNum * 10 + (c - '0');
                } else {
                    num = true;
                    curNum = (c - '0');
                }
            } else {
                if (num) {
                    suffix.add(String.valueOf(curNum));
                    num = false;
                    curNum = 0;
                }
                if (deque.isEmpty()) {
                    deque.offerLast(c);
                } else if (map.get(deque.peekLast()) >= map.get(c)) {
                    while (!deque.isEmpty() && map.get(deque.peekLast()) >= map.get(c)) {
                        suffix.add(String.valueOf(deque.pollLast()));
                    }
                    deque.offerLast(c);
                } else {
                    deque.offerLast(c);
                }
            }
        }
        suffix.add(String.valueOf(curNum));
        while (!deque.isEmpty()) {
            suffix.add(String.valueOf(deque.pollLast()));
        }

        ArrayDeque<Integer> nums = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < suffix.size(); i++) {
            String str = suffix.get(i);
            if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
                Integer a = nums.pollLast(), b = nums.pollLast();
                if ("+".equals(str)) nums.offerLast(a + b);
                if ("-".equals(str)) nums.offerLast(b - a);
                if ("*".equals(str)) nums.offerLast(a * b);
                if ("/".equals(str)) nums.offerLast(b / a);
            } else {
                nums.offerLast(Integer.parseInt(str));
            }
        }
        return nums.pollLast();
    }

    public static void main(String[] args) {
        Q227 q227 = new Q227();
        System.out.println(q227.calculate("1*2-3/4+5*6-7*8+9/10"));
    }
}
