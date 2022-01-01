package leetcode.ds1;

/*
https://leetcode.com/problems/maximum-subarray/
 */

public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray obj = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(obj.maxSubArray(nums));
    }

    // Brute-Force: Time limit exceeded
    public int maxSubArray1(int[] nums) {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                result = Math.max(result, sum);
            }
        }

        return result;
    }

    // Kadane's Algorithm.
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currentMax = Math.max(num, currentMax + num);
            max = Math.max(currentMax, max);
        }

        return max;
    }
}
