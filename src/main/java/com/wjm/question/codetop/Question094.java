package com.wjm.question.codetop;

import com.wjm.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author stephen wang
 */
public class Question094 {
    List<Integer> ans;

    public List<Integer> inorderTraversal01(TreeNode root) {
        ans = new ArrayList<>();
        func(root);
        return ans;
    }

    void func(TreeNode p) {
        if (p == null) {
            return;
        }
        func(p.left);
        ans.add(p.val);
        func(p.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;
        while (p != null || !s.empty()) {
            while (p != null) {
                s.add(p);
                p = p.left;
            }

            p = s.pop();
            ans.add(p.val);

            p = p.right;

        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode a3 = new TreeNode(3);
        TreeNode a2 = new TreeNode(2, a3, null);
        TreeNode t = new TreeNode(1, null, a2);
        Question094 q = new Question094();
        System.out.println(q.inorderTraversal(t));
    }
}
