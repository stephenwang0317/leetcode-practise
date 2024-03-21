package com.wjm.question.codetop;

import com.wjm.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author stephen wang
 */
public class Question102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode tail = root;
        List<Integer> sub = new ArrayList<>();
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
                list.add(list1);
                sub.clear();
                if (!q.isEmpty()) {
                    tail = q.getLast();
                } else {
                    tail = null;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(15);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(20, t1, t2);
        TreeNode t4 = new TreeNode(9);
        TreeNode t = new TreeNode(3, t4, t3);

        Question102 question102 = new Question102();
        List<List<Integer>> lists = question102.levelOrder(t);
        lists.forEach(System.out::println);
    }
}
