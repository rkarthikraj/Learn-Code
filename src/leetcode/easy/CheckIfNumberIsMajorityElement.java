package leetcode.easy;

/*
https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
Runtime: 5 ms, faster than 6.60% of Java online submissions for Check If a Number Is Majority Element in a Sorted Array.
Memory Usage: 39.1 MB, less than 20.21% of Java online submissions for Check If a Number Is Majority Element in a Sorted Array.

Runtime: 1 ms, faster than 14.23% of Java online submissions for Check If a Number Is Majority Element in a Sorted Array.
Memory Usage: 39.1 MB, less than 20.21% of Java online submissions for Check If a Number Is Majority Element in a Sorted Array.
 */

import java.util.HashMap;

class CheckIfNumberIsMajorityElement {
    public static void main(String[] args) {
        CheckIfNumberIsMajorityElement obj = new CheckIfNumberIsMajorityElement();
        // int[] nums = {2, 4, 5, 5, 5, 5, 5, 6, 6};
        // int target = 5;

        int[] nums = {10, 100, 101, 101};
        int target = 101;

        // System.out.println(obj.isMajorityElement(nums, target));
        System.out.println(obj.isMajorityElementOptimize(nums, target));
    }

    public boolean isMajorityElement(int[] nums, int target) {
        int len = nums.length;
        int avg = (int) Math.floor(len / 2);

        System.out.println("Length: " + len);
        System.out.println("Avg: " + avg);

        int low = 0;
        int high = len - 1;

        while (low < high) {
            if (nums[low] != target) {
                low++;
            }
            if (nums[high] != target) {
                high--;
            }

            if (nums[low] == target && nums[high] == target) {
                System.out.println("Low: " + low + ", High: " + high);
                int count = high - low + 1;
                System.out.println(count);
                if (count > avg) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    public boolean isMajorityElementOptimize(int[] nums, int target) {
        int len = nums.length;
        int avg = (int) Math.floor(len / 2);

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        Integer count = hm.get(target);
        if (count != null) {
            if (count > avg) {
                return true;
            }
        } else {
            return false;
        }

        return false;
    }
}