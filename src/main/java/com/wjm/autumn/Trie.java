package com.wjm.autumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Trie {
    class Node {
        char c;
        HashMap<Character, Node> children;
        boolean end;

        public Node(char c) {
            this.c = c;
            this.end = false;
            children = new HashMap<>();
        }

        public Node(char[] ss) {
            this.c = ss[0];
            this.children = new HashMap<>();
            Node p = this;
            for (int j = 1; j < ss.length; j++) {
                Node t = new Node(ss[j]);
                p.children.put(ss[j], t);
                p = t;
            }
            p.end = true;
        }
    }

    HashMap<Character, Node> forest;

    public Trie() {
        forest = new HashMap<>();
    }

    public void insert(String word) {
        char[] ss = word.toCharArray();
        if (forest.containsKey(ss[0])) {
            Node node = forest.get(ss[0]);
            int i = 1;
            while (i < ss.length && node.children.containsKey(ss[i])) {
                node = node.children.get(ss[i]);
                i++;
            }
            if (i == ss.length) {
                node.end = true;
            } else {
                char[] chars = Arrays.copyOfRange(ss, i, ss.length);
                Node node1 = new Node(chars);
                node.children.put(ss[i], node1);
            }
        } else {
            Node n = new Node(ss);
            forest.put(ss[0], n);
        }
    }

    public boolean search(String word) {
        char[] ss = word.toCharArray();
        if (!forest.containsKey(ss[0])) return false;
        Node root = forest.get(ss[0]);
        for (int i = 1; i < ss.length; i++) {
            if (!root.children.containsKey(ss[i])) return false;
            root = root.children.get(ss[i]);
        }
        return root.end;
    }

    public boolean startsWith(String prefix) {
        char[] ss = prefix.toCharArray();
        if (!forest.containsKey(ss[0])) return false;
        Node root = forest.get(ss[0]);
        for (int i = 1; i < ss.length; i++) {
            if (!root.children.containsKey(ss[i])) return false;
            root = root.children.get(ss[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}