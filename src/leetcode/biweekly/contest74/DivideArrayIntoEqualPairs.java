package leetcode.biweekly.contest74;

import java.util.HashMap;
import java.util.Map;

class DivideArrayIntoEqualPairs {
    public static void main(String[] args) {
        DivideArrayIntoEqualPairs obj = new DivideArrayIntoEqualPairs();
        int[] nums1 = {3, 2, 3, 2, 2, 2};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(obj.divideArray(nums1));
        System.out.println(obj.divideArray(nums2));

    }

    public boolean divideArray(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> countHM = new HashMap<>();
        for (int i = 0; i < length; i++) {
            countHM.put(nums[i], countHM.getOrDefault(nums[i], 0) + 1);
        }

        // System.out.println(countHM);
        for (Map.Entry<Integer, Integer> entry : countHM.entrySet()) {
            int value = entry.getValue();
            if (entry.getValue() % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}