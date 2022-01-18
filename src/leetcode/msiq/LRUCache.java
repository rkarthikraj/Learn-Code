package leetcode.msiq;

/*
https://leetcode.com/problems/lru-cache/
 */

import java.util.HashMap;
import java.util.Map;

class Node {
    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap();
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else
            return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
            remove(map.get(key));
        if (map.size() == capacity)
            remove(tail.prev);
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }



    public static void main(String... args) {
        LRUCache obj = null;
        String[] operations = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        int[][] values = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};

        for (int i = 0; i < values.length; i++) {
            String operation = operations[i];

            switch (operation) {
                case "LRUCache":
                    obj = new LRUCache(values[i][0]);
                    System.out.println("null");
                    break;
                case "put":
                    obj.put(values[i][0], values[i][1]);
                    System.out.println("Put: " + values[i][0] + ", HM: " + obj.map);
                    break;
                case "get":
                    System.out.println("Get: " + values[i][0] + " -> " + obj.get(values[i][0]));
                    break;
            }
        }
        System.out.println(obj.map);
    }
}