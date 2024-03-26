package com.wjm.question.codetop;

import com.wjm.data.TreeNode;

import java.util.*;

/**
 * @author stephen wang
 */
public class Question102_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        TreeNode last = root;

        while (!q.isEmpty()) {
            TreeNode head = q.poll();
            tmp.add(head.val);
            if (head.left != null) q.offer(head.left);

            if (head.right != null) q.offer(head.right);


            if (head == last) {
                ans.add(new ArrayList<>(tmp));
                tmp.clear();
                if (!q.isEmpty()) last = q.getLast();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Question102_2 q = new Question102_2();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<List<Integer>> lists = q.levelOrder(root);
        System.out.println(lists);
    }
}
