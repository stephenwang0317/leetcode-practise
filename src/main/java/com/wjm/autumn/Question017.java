package com.wjm.autumn;

import com.wjm.data.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Question017 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        TreeNode l = null, r = null;
        if (root.left != null) {
            l = lowestCommonAncestor(root.left, p, q);

        }
        if (root.right != null) {
            r = lowestCommonAncestor(root.right, p, q);
        }
        if (r == null && l == null) {
            return null;
        } else if (r != null && l != null) {
            return root;
        } else {
            return l != null ? l : r;
        }

    }
}
