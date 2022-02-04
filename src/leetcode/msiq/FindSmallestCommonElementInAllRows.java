package leetcode.msiq;

import java.util.HashMap;
import java.util.Map;

class FindSmallestCommonElementInAllRows {
    public static void main(String[] args) {
        FindSmallestCommonElementInAllRows obj = new FindSmallestCommonElementInAllRows();
        int[][] mat = {{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10}, {3, 5, 7, 9, 11}, {1, 3, 5, 7, 9}};
        System.out.println(obj.smallestCommonElement(mat));
    }

    public int smallestCommonElement(int[][] mat) {
        int minCommonValue = Integer.MAX_VALUE;
        int rows = mat.length;
        int columns = mat[0].length;

        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                hm.put(mat[i][j], hm.getOrDefault(mat[i][j], 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int value = entry.getValue();
            if (value == rows) {
                minCommonValue = Math.min(entry.getKey(), minCommonValue);
            }
        }

        System.out.println(hm);

        return minCommonValue == Integer.MAX_VALUE ? -1 : minCommonValue;
    }

    public int smallestCommonElementOptimized(int[][] mat) {
        int count[] = new int[10001];
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                ++count[mat[i][j]];
            }
        }
        for (int k = 1; k <= 10000; ++k) {
            if (count[k] == n) {
                return k;
            }
        }
        return -1;
    }
}