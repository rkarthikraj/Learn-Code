package leetcode.others;

import java.util.*;

class KWeakestRowsInMatrix {
    public static void main(String[] args) {
        KWeakestRowsInMatrix obj = new KWeakestRowsInMatrix();
        System.out.println(Arrays.toString(obj.kWeakestRows(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}}, 3)));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, List<Integer>> map = new TreeMap();

        int length = mat.length;
        for (int i = 0; i < length; ++i) {
            int count = 0;
            for (int j = 0; j < mat[i].length; ++j) {
                if (mat[i][j] == 0) {
                    break;
                }
                count++;
            }

            List<Integer> list = map.get(count);
            if (list == null) {
                list = new ArrayList();
                map.put(count, list);
            }
            list.add(i);
        }

        int[] result = new int[k];
        int i = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            for (int value : list) {
                if (i < k)
                    result[i++] = value;
            }
        }
        return result;
    }
}