package leetcode.msiq;

import java.util.Arrays;
import java.util.LinkedList;

/*
https://leetcode.com/problems/merge-intervals/
Runtime: 7 ms
Memory Usage: 41.7 MB
Solved by seeing solution.
 */

class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] intervals3 = {{1, 4}, {5, 6}};
        int[][] intervals4 = {{1, 4}, {0, 6}};
        int[][] intervals5 = {{1, 4}, {2, 3}};
        int[][] intervals6 = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};

        System.out.println(Arrays.deepToString(obj.merge(intervals1)));
        System.out.println(Arrays.deepToString(obj.merge(intervals2)));
        System.out.println(Arrays.deepToString(obj.merge(intervals3)));
        System.out.println(Arrays.deepToString(obj.merge(intervals4)));
        System.out.println(Arrays.deepToString(obj.merge(intervals5)));
        System.out.println(Arrays.deepToString(obj.merge(intervals6)));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> result = new LinkedList<>();
        boolean isMerged = false;

        for (int i = 0; i < intervals.length; i++) {
            if (result.isEmpty() || result.getLast()[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}