package com.wjm.autumn;

import java.util.ArrayDeque;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class Question015 {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            char c = ss[i];
            if (c == '(' || c == '[' || c == '{') {
                stack.offerLast(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.peekLast();
                if (match(top, c)) {
                    stack.pollLast();
                } else return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean match(char top, char c) {
        if (top == '(' && c == ')') {
            return true;
        } else if (top == '[' && c == ']') {
            return true;
        } else if (top == '{' && c == '}') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Question015 q = new Question015();
        boolean valid = q.isValid("()");
        System.out.println(valid);
    }
}
