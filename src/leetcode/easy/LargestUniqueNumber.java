package leetcode.easy;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/problems/largest-unique-number/submissions/
Runtime: 6 ms, faster than 21.02% of Java online submissions for Largest Unique Number.
Memory Usage: 39.2 MB, less than 36.31% of Java online submissions for Largest Unique Number.
 */

class LargestUniqueNumber {
    public static void main(String[] args) {
        LargestUniqueNumber obj = new LargestUniqueNumber();
        //int[] nums = {5, 7, 3, 9, 4, 9, 8, 3, 1};
        //int[] nums = {9, 9, 8, 8};
        int[] nums = {11, 10, 11};
        System.out.println(obj.largestUniqueNumber(nums));
    }

    public int largestUniqueNumber(int[] nums) {
        TreeMap<Integer, Integer> tm = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            tm.put(nums[i], tm.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            int count = entry.getValue();
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public int largestUniqueNumberLeetcodeSolution(int[] nums) {
        int[] count = new int[1001];
        int max = 0;
        for (int n : nums) {
            count[n]++;
            max = Math.max(n, max);
        }
        for (int i = max; i >= 0; i--) {
            if (count[i] == 1)
                return i;
        }
        return -1;
    }

}