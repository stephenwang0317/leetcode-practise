package com.wjm.autumn;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
public class Question003 {
    static class LRUCache {
        class Node {
            public Integer key;
            public Integer val;
            public Node pre;
            public Node next;

            public Node(Integer k, Integer v, Node p, Node n) {
                this.key = k;
                this.val = v;
                this.pre = p;
                this.next = n;
            }

        }

        public Node head;
        public Node tail;
        public Map<Integer, Node> map;
        public Integer cap;
        public Integer size;


        public LRUCache(int capacity) {
            this.cap = capacity;
            this.head = new Node(-1, -1, null, null);
            this.tail = new Node(-1, -1, null, null);
            head.next = tail;
            tail.pre = head;
            this.map = new HashMap<>();
            this.size = 0;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) return -1;
            else {
                node.pre.next = node.next;
                node.next.pre = node.pre;

                node.next = head.next;
                head.next.pre = node;
                head.next = node;
                node.pre = head;

                return node.val;

            }
        }

        public void put(int key, int value) {
            Node node1 = map.get(key);
            if (node1 == null) {
                Node n = new Node(key, value, null, null);
                map.put(key, n);

                n.next = head.next;
                head.next.pre = n;
                head.next = n;
                n.pre = head;

                size++;

                if (size > cap) {
                    Node pre = tail.pre;

                    map.remove(pre.key);

                    pre.pre.next = tail;
                    tail.pre = pre.pre;
                    pre = null;
                    size--;
                }
            } else {
                node1.val = value;
                map.put(key, node1);

                node1.pre.next = node1.next;
                node1.next.pre = node1.pre;

                node1.next = head.next;
                head.next.pre = node1;
                head.next = node1;
                node1.pre = head;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }
}
