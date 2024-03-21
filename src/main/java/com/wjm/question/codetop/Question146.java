package com.wjm.question.codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author stephen wang
 */
public class Question146 {
    static class LRUCache {
        Map<Integer, BiListNode> map;
        int cap;
        BiListNode head;
        BiListNode tail;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            cap = capacity;
            head = new BiListNode(-1, -1);
            tail = new BiListNode(-1, -1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                BiListNode node = map.get(key);


                // node 单独拿出来
                node.pre.next = node.next;
                node.next.pre = node.pre;

                node.next = head.next;
                node.pre = head;
                head.next = node;
                node.next.pre = node;

                return map.get(key).val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            BiListNode tmp = new BiListNode(key, value);

            if (map.containsKey(key)) {
                map.get(key).val = value;
                get(key);
                return;
            }

            if (map.size() >= cap) {
                BiListNode pre = tail.pre;
                tail.pre = pre.pre;
                pre.pre.next = tail;
                map.remove(pre.key);
            }

            tmp.next = head.next;
            tmp.pre = head;
            head.next = tmp;
            tmp.next.pre = tmp;
            map.put(key, tmp);
        }
    }

    static class BiListNode {
        int key;
        int val;
        BiListNode pre;
        BiListNode next;

        BiListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(3, 2);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));

        lruCache.put(4, 3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
