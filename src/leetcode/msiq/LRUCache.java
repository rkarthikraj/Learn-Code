package leetcode.msiq;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
Not Solved
https://leetcode.com/problems/lru-cache/
 */

class LRUCache {
    Map<Integer, Integer> lruHM;
    List<Integer> tracker;
    int capacity = 0;

    public LRUCache(int capacity) {
        lruHM = new HashMap<>();
        this.capacity = capacity;
        tracker = new LinkedList<>();
    }

    public int get(int key) {
        if (lruHM.containsKey(key)) {
            return lruHM.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (lruHM.size() >= capacity && tracker.size() >= capacity) {
            Integer cacheValue = lruHM.get(key);
            if (cacheValue == null) {
                int lru = tracker.get(0);
                lruHM.remove(lru);
                tracker.remove(0);
                lruHM.put(key, value);
                tracker.add(key);
            } else {
                tracker.remove(0);
                lruHM.put(key, value);
                tracker.add(key);
            }
        } else {
            lruHM.put(key, value);
            tracker.add(key);
        }
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
                    System.out.println("Put: " + values[i][0] + ", HM: " + obj.lruHM + ", Tracker: " + obj.tracker);
                    //System.out.println(obj.lruHM);
                    //System.out.println(obj.tracker);
                    break;
                case "get":
                    System.out.println("Get: " + values[i][0] + " -> " + obj.get(values[i][0]));
                    break;
            }
        }

        System.out.println(obj.lruHM);
    }
}