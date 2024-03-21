package com.wjm.question.codetop;

import com.wjm.data.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author stephen wang
 */
public class Question103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode tail = root;
        List<Integer> sub = new ArrayList<>();
        int lv = 0;
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            sub.add(t.val);
            if (t.left != null) {
                q.offer(t.left);
            }
            if (t.right != null) {
                q.offer(t.right);
            }

            if (t == tail) {
                ArrayList<Integer> list1 = new ArrayList<>(sub);
                if (lv % 2 == 0) {
                    list.add(list1);
                } else {
                    Collections.reverse(list1);
                    list.add(list1);
                }
                sub.clear();
                if (!q.isEmpty()) {
                    tail = q.getLast();
                } else {
                    tail = null;
                }
                lv++;
            }
        }
        return list;
    }
}
