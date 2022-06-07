package leetcode.others;

import java.util.Arrays;
import java.util.HashMap;

class MaxNumberOfKSumPair {
    public static void main(String[] args) {
        MaxNumberOfKSumPair obj = new MaxNumberOfKSumPair();
        int result1 = obj.maxOperations(new int[]{1, 2, 3, 4}, 5);
        int result2 = obj.maxOperations(new int[]{3, 1, 3, 4, 3}, 6);
        System.out.println("Result: " + result1);
        System.out.println("Result: " + result2);
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int counter = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                left++;
                right--;
                counter++;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return counter;
    }

    public int maxOperationsUsingHM(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = k - nums[i];
            if (map.getOrDefault(current, 0) > 0 && map.getOrDefault(complement, 0) > 0) {
                if ((current == complement) && map.get(current) < 2) continue;
                map.put(current, map.get(current) - 1);
                map.put(complement, map.get(complement) - 1);
                count++;
            }
        }
        return count;
    }
}
