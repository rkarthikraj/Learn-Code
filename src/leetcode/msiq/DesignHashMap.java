package leetcode.msiq;

import java.util.HashMap;
import java.util.Map;

class MyHashMap {
    Map<Integer, Integer> hm;

    public MyHashMap() {
        hm = new HashMap<Integer, Integer>();
    }

    public void put(int key, int value) {
        hm.put(key, value);
    }

    public int get(int key) {
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        return -1;
    }

    public void remove(int key) {
        if (hm.containsKey(key)) {
            hm.remove(key);
        }
    }

    public void print() {
        System.out.println(hm);
    }
}

public class DesignHashMap {
    public static void main(String... args) {
        MyHashMap obj = null;
        // String[] operations = {"MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"};
        // int[][] values = {{}, {1, 1}, {2, 2}, {1}, {3}, {2, 1}, {2}, {2}, {2}};

        String[] operations = {"MyHashMap", "remove", "get", "put", "put", "put", "get", "put", "put", "put", "put"};
        int[][] values = {{}, {14}, {4}, {7, 3}, {11, 1}, {12, 1}, {7}, {1, 19}, {0, 3}, {1, 8}, {2, 6}};

        for (int i = 0; i < values.length; i++) {
            String operation = operations[i];

            switch (operation) {
                case "MyHashMap":
                    obj = new MyHashMap();
                    break;
                case "put":
                    obj.put(values[i][0], values[i][1]);
                    break;
                case "get":
                    obj.get(values[i][0]);
                    break;
                case "remove":
                    obj.remove(values[i][0]);
                    break;
            }
        }

        obj.print();
    }
}
