package com.wjm.autumn;

import com.wjm.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Question011 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerFirst(root);
        TreeNode tail = root;

        List<Integer> tmp = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            tmp.add(node.val);
            if (node.left != null) q.offerLast(node.left);
            if (node.right != null) q.offerLast(node.right);
            if (node == tail) {
                ans.add(new ArrayList<>(tmp));
                tmp.clear();
                tail = q.peekLast();
            }
        }
        return ans;
    }
}
