package com.wjm.question.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author stephen wang
 */
public class Question022 {
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        func(n, 0, 0, sb);
        return ans;
    }

    void func(int n, int l, int r, StringBuilder sb) {
        /*
         * t是已经放入的左
         * */
        if (l + r >= 2 * n) {
            ans.add(sb.toString());
            return;
        }

        if (l < n) {
            sb.append('(');
            func(n, l + 1, r, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < n && r < l) {
            sb.append(')');
            func(n, l, r + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        Question022 q = new Question022();
        List<String> strings = q.generateParenthesis(3);
        strings.forEach(System.out::println);
    }
}
