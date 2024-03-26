package com.wjm.question.codetop;

import com.wjm.data.TreeNode;

/**
 * @author stephen wang
 */
public class Question236_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) {
            return root;
        }
        TreeNode a = lowestCommonAncestor(root.left, p, q);
        TreeNode b = lowestCommonAncestor(root.right, p, q);
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        Question236_2 m = new Question236_2();
        TreeNode a = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        TreeNode b = new TreeNode(5, new TreeNode(6), a);
        TreeNode c = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root = new TreeNode(3, b, c);
        TreeNode treeNode = m.lowestCommonAncestor(root, b, c);
        System.out.println(treeNode.val);
    }
}
