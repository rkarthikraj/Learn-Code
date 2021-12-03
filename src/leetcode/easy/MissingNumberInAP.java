package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/missing-number-in-arithmetic-progression/submissions/
Runtime: 11 ms, faster than 12.11% of Java online submissions for Missing Number In Arithmetic Progression.
Memory Usage: 38.4 MB, less than 96.41% of Java online submissions for Missing Number In Arithmetic Progression.
 */

class MissingNumberInAPSolution {
    public int missingNumber(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);

        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            list.add(arr[i]);
            int cache = 0;
            int check = i + 1;
            if (check < arr.length) {
                cache = arr[check] - arr[i];
                diff = Math.min(diff, cache);
            }
        }

        System.out.println("Diff: " + diff);

        if (diff == 0) {
            return arr[0];
        }

        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i) + diff;
            if (!list.contains(value)) {
                return value;
            }
        }

        return 0;
    }
}

public class MissingNumberInAP {
    public static void main(String[] args) {
        MissingNumberInAPSolution obj = new MissingNumberInAPSolution();
        int[] arr = {5, 7, 11, 13}; // 9
        int[] arr2 = {15, 13, 12}; // 14
        int[] arr3 = {100, 300, 400}; // 200

        //System.out.println(obj.missingNumber(arr));
        //System.out.println(obj.missingNumber(arr2));
        //System.out.println(obj.missingNumber(arr3));
    }
}
