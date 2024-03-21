package com.wjm.question.codetop;

import com.wjm.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author stephen wang
 */
public class Question199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode tail = root;
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t.left != null) {
                q.offer(t.left);
            }
            if (t.right != null) {
                q.offer(t.right);
            }

            if (t == tail) {
                list.add(t.val);
                if (!q.isEmpty()) {
                    tail = q.getLast();
                } else {
                    tail = null;
                }
            }
        }
        return list;
    }
}
