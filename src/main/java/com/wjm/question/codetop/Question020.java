package com.wjm.question.codetop;

import java.util.Stack;

/**
 * @author stephen wang
 */
public class Question020 {
    public boolean isValid(String s) {
        char[] ss = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : ss) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Question020 question020 = new Question020();
        System.out.println(question020.isValid("()"));
        System.out.println(question020.isValid("()[]{}"));
        System.out.println(question020.isValid("(((()"));
        System.out.println(question020.isValid("(]"));
    }
}
