package com.wjm.question.leetcode;

/**
 * @author stephen wang
 */
public class Question8 {
    public int myAtoi(String s) {
        char[] ss = s.toCharArray();
        int i = 0;
        long cur_num = 0;
        int flag = 1;
        int state_cur = 0;
        int state_end = 999; // end
        while (state_cur != state_end && i < ss.length) {
            if (state_cur == 0) {
                if (ss[i] == '+') {
                    flag = 1;
                    state_cur = 1;
                } else if (ss[i] == '-') {
                    flag = -1;
                    state_cur = 1;
                } else if (ss[i] == ' ') {

                } else if (ss[i] >= '0' && ss[i] <= '9') {
                    cur_num += ss[i] - '0';
                    state_cur = 1; //准备接收数字
                } else {
                    break;
                }
            } else if (state_cur == 1) {
                if (ss[i] >= '0' && ss[i] <= '9') {
                    cur_num *= 10;
                    if (cur_num > Integer.MAX_VALUE) {
                        break;
                    }
                    cur_num += ss[i] - '0';
                } else {
                    break;
                }
            }
            i++;
        }
        if (cur_num > Integer.MAX_VALUE && flag == 1) {
            return Integer.MAX_VALUE;
        }
        if (cur_num > Integer.MAX_VALUE && flag == -1) {
            return Integer.MIN_VALUE;
        }
        return (int) (cur_num * flag);
    }

    public static void main(String[] args) {
        Question8 question8 = new Question8();
        System.out.println(question8.myAtoi("-0012a42"));
    }
}
