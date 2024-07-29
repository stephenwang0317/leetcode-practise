package com.wjm.question.meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test03 {
    static class TreeNode {
        Character c;
        TreeNode left;
        TreeNode right;

        public TreeNode(Character c, TreeNode left, TreeNode right) {
            this.c = c;
            this.left = left;
            this.right = right;
        }

        public TreeNode(Character c) {
            this.c = c;
        }
    }

    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        TreeNode[] nodes = new TreeNode[n];
        String s = scanner.nextLine();
        char[] ss = s.toCharArray();
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(ss[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            int a = Integer.parseInt(split[0]) - 1, b = Integer.parseInt(split[1]) - 1;
            if (nodes[a].left == null) nodes[a].left = nodes[b];
            else nodes[a].right = nodes[b];
        }
        func(nodes[0]);
        System.out.println(ans);
    }

    static Character func(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.c;
        }
        Character left = ' ', right = ' ';
        if (root.left != null)
            left = func(root.left);
        if (root.right != null)
            right = func(root.right);
        if (right == 'Y' || left == 'Y') {
            ans++;
            return 'Y';
        }

        Set<Character> set = new HashSet<>();
        set.add(left);
        set.add(right);
        set.add(root.c);
        if (set.contains('R') && set.contains('B')) {
            ans++;
            return 'Y';
        }
        return root.c;
    }
}
