package com.wjm.question.codetop;

import com.wjm.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author stephen wang
 */
public class Question257 {
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        func(new ArrayDeque<>(), root);
        return ans;
    }

    public void func(ArrayDeque<Integer> q, TreeNode p) {
        q.offerLast(p.val);
        if (p.left == null && p.right == null) {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(q.toArray()).forEach(c -> sb.append(c).append("->"));
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            ans.add(sb.toString());
        }

        if (p.left != null) {
            func(q, p.left);
        }

        if (p.right != null) {
            func(q, p.right);
        }

        q.pollLast();
    }
}
