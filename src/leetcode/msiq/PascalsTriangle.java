package leetcode.msiq;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/pascals-triangle/
Runtime: 11 ms, faster than 22.65% of Java online submissions for Pascal's Triangle.
Memory Usage: 38.6 MB, less than 8.63% of Java online submissions for Pascal's Triangle.
 */
class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle obj = new PascalsTriangle();
        System.out.println(obj.generate(1));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultantList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<>();
            int[] value = null;
            if (i >= 2) {
                value = resultantList.get(i - 1).stream().mapToInt(Integer::intValue).toArray();
            }

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    innerList.add(1);
                } else {
                    if (value != null) {
                        for (int k = 0; k < value.length; k++) {
                            if (innerList.size() <= (i - 1) && (k + 1) < value.length) {
                                innerList.add(value[k] + value[k + 1]);
                            }
                        }
                    }
                }
            }
            resultantList.add(innerList);
        }
        return resultantList;
    }
}