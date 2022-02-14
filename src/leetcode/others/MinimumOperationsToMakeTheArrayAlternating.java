package leetcode.others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Even Position Change = Total Even Position - Max Even Values == (n + 1) / 2 - maxEvenValue
 * Odd Position Change  = Total Odd Position  - Max Odd Values == (n/2) - maxOddValue
 *                      = n - Max Even Values - Max Odd Values
 */
class MinimumOperationsToMakeTheArrayAlternating {
    public static void main(String[] args) {
        MinimumOperationsToMakeTheArrayAlternating obj = new MinimumOperationsToMakeTheArrayAlternating();
        int[] nums1 = {3, 1, 3, 2, 4, 3};
        int[] nums2 = {1, 2, 2, 2, 2};
        int[] nums3 = {69, 91, 47, 74, 75, 94, 22, 100, 43, 50, 82, 47, 40, 51, 90, 27, 98, 85, 47, 14, 55, 82, 52, 9, 65, 90, 86, 45, 52, 52, 95, 40, 85, 3, 46, 77, 16, 59, 32, 22, 41, 87, 89, 78, 59, 78, 34, 26, 71, 9, 82, 68, 80, 74, 100, 6, 10, 53, 84, 80, 7, 87, 3, 82, 26, 26, 14, 37, 26, 58, 96, 73, 41, 2, 79, 43, 56, 74, 30, 71, 6, 100, 72, 93, 83, 40, 28, 79, 24};
        System.out.println(obj.minimumOperations(nums1));
        System.out.println(obj.minimumOperations(nums2));
        System.out.println(obj.minimumOperations(nums3));
    }

    public int minimumOperations(int[] nums) {
        int count = 0;
        int length = nums.length;

        Map<Integer, Integer> evenMap = new HashMap<>();
        Map<Integer, Integer> oddMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                evenMap.put(nums[i], evenMap.getOrDefault(nums[i], 0) + 1);
            } else {
                oddMap.put(nums[i], oddMap.getOrDefault(nums[i], 0) + 1);
            }
        }

        //System.out.println("Even Map: " + evenMap);
        //System.out.println("Odd Map: " + oddMap);

        int[] sortedEvenFirstMax = sortedHashMap(evenMap, null);
        int[] sortedOddFirstMax = sortedHashMap(oddMap, null);

        //System.out.println("Even Max: " + Arrays.toString(sortedEvenFirstMax));
        //System.out.println("Odd Max: " + Arrays.toString(sortedOddFirstMax));

        if (sortedEvenFirstMax[0] != sortedOddFirstMax[0]) {
            return length - sortedEvenFirstMax[1] - sortedOddFirstMax[1];
        } else {
            int[] sortedEvenSecondMax = sortedHashMap(evenMap, sortedEvenFirstMax[0]);
            int[] sortedOddSecondMax = sortedHashMap(oddMap, sortedOddFirstMax[0]);

            int ans1 = length - sortedEvenFirstMax[1] - sortedOddSecondMax[1];
            int ans2 = length - sortedEvenSecondMax[1] - sortedOddFirstMax[1];
            return Math.min(ans1, ans2);
        }
    }

    public int[] sortedHashMap(Map<Integer, Integer> map, Integer firstMax) {
        int maxKey = 0;
        int maxValue = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (firstMax != null && firstMax == key)
                continue;
            int value = entry.getValue();
            if (value > maxValue) {
                maxValue = value;
                maxKey = key;
            }
        }

        return new int[]{maxKey, maxValue};
    }
}
