package com.wjm.question.lc75;

import com.wjm.data.TreeNode;

public class Q104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
