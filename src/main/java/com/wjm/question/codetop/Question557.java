package com.wjm.question.codetop;

/**
 * @author stephen wang
 */
public class Question557 {
    public String reverseWords(String s) {
        char[] ss = s.toCharArray();
        int l = 0, r = 0;
        for (; r < ss.length; r++) {
            if (ss[r] == ' ') {
                subFunc(ss, l, r - 1);
                l = r + 1;
            }
        }
        subFunc(ss, l, r - 1);
        return String.copyValueOf(ss);
    }

    public void subFunc(char[] ss, int l, int r) {
        for (int i = 0; l+i <= (l + r) / 2; i++) {
            char tmp = ss[l + i];
            ss[l + i] = ss[r - i];
            ss[r - i] = tmp;
        }
    }

    public static void main(String[] args) {
        Question557 m = new Question557();
        System.out.println(m.reverseWords("Let's take LeetCode contest"));
    }
}
