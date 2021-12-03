package optimize;

import java.util.Arrays;
import java.util.Comparator;

public class SortArray2D {
    public static void main(String[] args) {
        // int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        // int[][] intervals = {{7, 10}, {2, 4}};
        // int[][] intervals = {{13, 15}, {1, 13}};
        int[][] intervals = {{9, 14}, {5, 6}, {3, 5}, {12, 19}};

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            System.out.println(intervals[i][0] + "-" + intervals[i][1]);
        }
    }
}
