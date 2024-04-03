package com.wjm.question.lc75;

import com.wjm.data.TreeNode;

import java.util.ArrayDeque;

public class Q1161 {
    public int maxLevelSum(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        int max = Integer.MIN_VALUE;
        int ans = -1;
        int cur = 1;
        TreeNode tail = root;
        while (!q.isEmpty()) {
            TreeNode p;
            int sum = 0;
            while (!q.isEmpty() && (p = q.pollFirst()) != tail) {
                sum += p.val;
                if (p.left != null) q.offerLast(p.left);
                if (p.right != null) q.offerLast(p.right);
            }
            sum += tail.val;
            if (tail.left != null) q.offerLast(tail.left);
            if (tail.right != null) q.offerLast(tail.right);
            if (sum > max) {
                max = sum;
                ans = cur;
            }
            tail = q.peekLast();
            cur++;
        }
        return ans;
    }
}
