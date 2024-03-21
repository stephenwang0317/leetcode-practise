package com.wjm.question.codetop;

import com.wjm.data.TreeNode;

/**
 * @author stephen wang
 */
public class Question236 {
    TreeNode ans;

    boolean travel(TreeNode root, TreeNode p, TreeNode q) {
        if (ans != null) {
            return false;
        }

        boolean a, b;
        a = root.left != null && travel(root.left, p, q);
        b = root.right != null && travel(root.right, p, q);

        if (root == p || root == q) {
            if (!a && !b) {
                return true;
            } else {
                ans = root;
                return false;
            }

        } else {
            if (a && b) {
                this.ans = root;
                return true;
            } else {
                return a || b;
            }
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        travel(root, p, q);
        return ans;
    }
}
