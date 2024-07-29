package com.wjm.question.other;

public class MyHashMap<K, V> {
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    Node<K, V>[] map;
    int capacity;
    int size;
    float loadFactor;

    public MyHashMap(int cap) {
        capacity = findCap(cap);
        map = new Node[capacity];
        size = 0;
        loadFactor = 0.75f;
    }

    public MyHashMap() {
        capacity = 16;
        map = new Node[capacity];
        size = 0;
        loadFactor = 0.25f;
    }

    public void put(K key, V value) {
        if (size >= capacity * loadFactor) rehash();
        putVal(key, value, map);
    }

    private void putVal(K key, V value, Node[] nodes) {
        int i = key.hashCode();
        int hash = i & (capacity - 1);
        if (nodes[hash] == null) {
            nodes[hash] = new Node<>(key, value);
            size++;
            return;
        }
        Node kvNode = nodes[hash];
        while (!key.equals(kvNode.key) && kvNode.next != null) {
            kvNode = kvNode.next;
        }
        if (key.equals(kvNode.key)) {
            kvNode.value = value;
        } else {
            kvNode.next = new Node<>(key, value);
            size++;
        }
    }

    void rehash() {
        Node[] newMap = new Node[capacity * 2];
        size = 0;
        capacity *= 2;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == null) continue;
            Node n = map[i];
            while (n != null) {
                putVal((K) n.key, (V) n.value, newMap);
                n = n.next;
            }
        }
        map = newMap;
    }

    public V get(K key) {
        int hash = key.hashCode() & (capacity - 1);
        if (map[hash] == null) return null;
        Node kvNode = map[hash];
        while (kvNode != null && !key.equals(kvNode.key)) {
            kvNode = kvNode.next;
        }
        return (V) kvNode.value;
    }

    private int findCap(int cap) {
        int n = cap;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> my = new MyHashMap<>();
        my.put(1, "111");
        my.put(2, "222");
        my.put(5, "555");
        my.put(21,"二十一");
        //my.put(3, "333");
        //my.put(4, "444");
        //my.put(3, "三三三");
        //my.put(5, "五五五");

        System.out.println(my.get(1));
        System.out.println(my.get(2));
        System.out.println(my.get(3));
        System.out.println(my.get(4));
        System.out.println(my.get(5));
        System.out.println(my.get(21));


    }
}
