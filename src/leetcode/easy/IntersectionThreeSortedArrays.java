package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
https://leetcode.com/problems/intersection-of-three-sorted-arrays/submissions/
Runtime: 10 ms, faster than 10.19% of Java online submissions for Intersection of Three Sorted Arrays.
Memory Usage: 46.1 MB, less than 5.55% of Java online submissions for Intersection of Three Sorted Arrays.
 */

class IntersectionThreeSortedArraysSolution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            loadHashMap(hm, arr1[i]);
            loadHashMap(hm, arr2[i]);
            loadHashMap(hm, arr3[i]);
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int value = entry.getValue();
            if (value == 3) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public void loadHashMap(HashMap<Integer, Integer> hm, int num) {
        Integer value = hm.get(num);
        if (value == null) {
            hm.put(num, 1);
        } else {
            hm.put(num, hm.get(num).intValue() + 1);
        }
    }

    /*
    Runtime: 2 ms, faster than 75.17% of Java online submissions for Intersection of Three Sorted Arrays.
    Memory Usage: 43.4 MB, less than 24.58% of Java online submissions for Intersection of Three Sorted Arrays.
     */
    public List<Integer> arraysIntersectionOptimize(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
            if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
                result.add(arr1[p1]);
                p1++;
                p2++;
                p3++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else if (arr2[p2] < arr3[p3]) {
                p2++;
            } else {
                p3++;
            }
        }

        return result;
    }
}

public class IntersectionThreeSortedArrays {
    public static void main(String[] args) {
        IntersectionThreeSortedArraysSolution obj = new IntersectionThreeSortedArraysSolution();
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 5, 7, 9};
        int[] arr3 = {1, 3, 4, 5, 8};
        System.out.println(obj.arraysIntersection(arr1, arr2, arr3));
        System.out.println(obj.arraysIntersectionOptimize(arr1, arr2, arr3));
    }
}
