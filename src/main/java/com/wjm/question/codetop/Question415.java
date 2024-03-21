package com.wjm.question.codetop;

import java.util.Collections;

/**
 * @author stephen wang
 */
public class Question415 {
    public String addStrings(String num1, String num2) {
        char[] a = num1.toCharArray(), b = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int curA = a.length - 1, curB = b.length - 1;
        int carry = 0;
        while (curA >= 0 && curB >= 0) {
            int x = (a[curA] - '0') + (b[curB] - '0') + carry;
            carry = 0;
            if (x >= 10) {
                carry = x / 10;
                x -= 10;
            }
            sb.append((char) (x + '0'));
            curA--;
            curB--;
        }

        while (curA >= 0) {
            int x = (a[curA] - '0') + carry;
            carry = 0;
            if (x >= 10) {
                carry = x / 10;
                x -= 10;
            }
            sb.append((char) (x + '0'));
            curA--;
        }
        while (curB >= 0) {
            int x = (b[curB] - '0') + carry;
            carry = 0;
            if (x >= 10) {
                carry = x / 10;
                x -= 10;
            }
            sb.append((char) (x + '0'));
            curB--;
        }
        if (carry != 0) {
            sb.append((char) (carry + '0'));
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Question415 q = new Question415();
        System.out.println(q.addStrings("11", "123"));
    }
}
