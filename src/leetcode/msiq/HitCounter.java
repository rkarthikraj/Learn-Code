package leetcode.msiq;

import java.util.*;

/*
https://leetcode.com/problems/design-hit-counter/
Runtime: 2 ms, faster than 31.19% of Java online submissions for Design Hit Counter.
Memory Usage: 37.3 MB, less than 43.27% of Java online submissions for Design Hit Counter.

Optimized
Runtime: 1 ms, faster than 92.98% of Java online submissions for Design Hit Counter.
Memory Usage: 36.7 MB, less than 98.05% of Java online submissions for Design Hit Counter.
 */
class HitCounter {
    TreeMap<Integer, Integer> tm;
    Queue<Integer> qp;
    int COUNTER_TIME_WINDOW = 300;

    public HitCounter() {
        tm = new TreeMap<>();
        qp = new LinkedList<>();
    }

    public void hit(int timestamp) {
        tm.put(timestamp, tm.getOrDefault(timestamp, 0) + 1);
        if(!qp.contains(timestamp)) {
            qp.add(timestamp);
        }
    }

    public int getHits(int timestamp) {
        while (!qp.isEmpty() && qp.peek() <= timestamp - COUNTER_TIME_WINDOW) {
            tm.remove(qp.poll());
        }

        // int window = Math.abs(timestamp - COUNTER_TIME_WINDOW);
        //System.out.println(timestamp + " - " + COUNTER_TIME_WINDOW + " = " + window);

        int getHitsCount = 0;

        for(Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            int value = entry.getValue();
            getHitsCount += value;
        }

        return getHitsCount;
    }

    public void hitOptimize(int timestamp) {
            qp.add(timestamp);
    }

    public int getHitsOptimize(int timestamp) {
        while (!qp.isEmpty() && qp.peek() <= timestamp - COUNTER_TIME_WINDOW) {
           qp.remove();
        }
        return qp.size();
    }

    public static void main(String[] args) {
        HitCounter obj = new HitCounter();

         // String[] operations = {"HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"};
         // int[][] values = {{}, {1}, {2}, {3}, {4}, {300}, {300}, {301}};

          String[] operations = {"HitCounter", "hit", "hit", "hit", "hit", "getHits"};
          int[][] values = {{}, {1}, {1}, {1}, {300}, {300}};

         // String[] operations = {"HitCounter", "hit", "hit", "hit", "hit", "hit", "hit", "getHits", "hit", "getHits", "hit", "getHits"};
         // int[][] values = {{}, {100}, {282}, {411}, {609}, {620}, {744}, {879}, {956}, {976}, {998}, {1055}};

        for (int i = 0; i < values.length; i++) {
            String operation = operations[i];

            switch (operation) {
                case "HitCounter":
                    obj = new HitCounter();
                    break;
                case "hit":
                    obj.hitOptimize(values[i][0]);
                    break;
                case "getHits":
                    // obj.getHits(values[i][0]);
                    System.out.print("\t" + obj.getHitsOptimize(values[i][0]));
                    // dSystem.out.println("Get hits: " + values[i][0] + " - " + obj.tm + ", Queue: " + obj.qp) ;
                    break;
            }
        }
    }
}
