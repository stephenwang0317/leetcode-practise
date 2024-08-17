package com.wjm.autumn;

import com.wjm.data.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Question018 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root==null) return ans;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        TreeNode tail = root;
        boolean r = false;
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            TreeNode p = q.pollFirst();
            while (p != tail) {
                tmp.add(p.val);
                if (p.left != null) q.offerLast(p.left);
                if (p.right != null) q.offerLast(p.right);
                p = q.pollFirst();
            }
            tmp.add(p.val);
            if (p.left != null) q.offerLast(p.left);
            if (p.right != null) q.offerLast(p.right);
            tail = q.peekLast();
            if (r) Collections.reverse(tmp);
            ans.add(new ArrayList<>(tmp));
            tmp.clear();
            r = !r;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Question018 q = new Question018();
        List<List<Integer>> lists = q.zigzagLevelOrder(root);
        lists.forEach(System.out::println);
    }
}
