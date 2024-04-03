package com.wjm.data;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author stephen wang
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("[");
        if (root == null) return "[]";
        //ArrayDeque<TreeNode> q = new ArrayDeque<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int cnt = 1;
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            if (t == null && cnt > 0) {
                sb.append("null,");
            } else if (t != null) {
                cnt--;
                sb.append(t.val).append(",");
                q.offer(t.left);
                q.offer(t.right);
                if (t.left != null) cnt++;
                if (t.right != null) cnt++;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        boolean f = true;
        TreeNode ret = null;
        for (String s : split) {
            TreeNode treeNode = null;

            try {
                int i = Integer.parseInt(s);
                treeNode = new TreeNode(i);
            } catch (NumberFormatException ignored) {

            }

            if (q.isEmpty()) {
                q.offer(treeNode);
                ret = treeNode;
            } else {
                TreeNode peek = q.peek();
                if (f) {
                    peek.left = treeNode;
                    f = false;

                } else {
                    peek.right = treeNode;
                    f = true;
                    q.poll();
                }
                if (treeNode != null)
                    q.offer(treeNode);
            }
        }
        return ret;
    }
}
