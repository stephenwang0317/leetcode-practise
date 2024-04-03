package com.wjm.question.lc75;

import com.wjm.data.TreeNode;

import java.util.Arrays;

public class Q1372 {
    int ans = 0;

    public int longestZigZag(TreeNode root) {
        int[] func = func(root);
        return ans;
    }

    public int[] func(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new int[]{0, 0};
        }
        int[] ret = new int[2];
        if (root.left != null) {
            ret[0] = func(root.left)[1] + 1;
            ans = Math.max(ans, ret[0]);
        }

        if (root.right != null) {
            ret[1] = func(root.right)[0] + 1;
            ans = Math.max(ans, ret[1]);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(7, null, new TreeNode(8));
        TreeNode t41 = new TreeNode(6, null, t5);
        TreeNode t32 = new TreeNode(4, t41, new TreeNode(5));
        TreeNode t2 = new TreeNode(2, new TreeNode(3), t32);
        TreeNode root = new TreeNode(1, null, t2);
        Q1372 q = new Q1372();
        System.out.println(q.longestZigZag(root));
    }
}
