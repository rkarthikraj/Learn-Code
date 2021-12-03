package leetcode.easy;

import java.util.*;

/*
https://leetcode.com/problems/high-five/
Runtime: 8 ms, faster than 27.94% of Java online submissions for High Five.
Memory Usage: 43 MB, less than 24.41% of Java online submissions for High Five.

Need to do it with Priority Key, TreeMap.
 */

public class HighFive {
    public static void main(String[] args) {
        HighFive obj = new HighFive();
        int[][] items = {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}};
        System.out.println(Arrays.deepToString(obj.highFive(items)));
    }

    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> hm = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            Queue<Integer> marks = hm.get(items[i][0]);
            if (marks == null) {
                marks = new PriorityQueue<>();
                hm.put(items[i][0], marks);
            }
            marks.add(items[i][1]);
            if (marks.size() > 5) {
                // System.out.println(marks.size());
                // System.out.println(marks.poll());
                marks.poll();
            }
        }

        System.out.println(hm);
        int[][] result = new int[hm.size()][2];
        int counter = 0;
        for (Map.Entry<Integer, Queue<Integer>> entry : hm.entrySet()) {
            int key = entry.getKey();
            Queue<Integer> marks = entry.getValue();

            int totalMarks = 0;
            while (!marks.isEmpty()) {
                totalMarks += marks.poll();
            }

            result[counter][0] = key;
            result[counter][1] = (totalMarks / 5);
            counter++;
        }

        return result;
    }
}
