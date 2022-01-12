package leetcode.ds1;

import java.util.Arrays;

/*
Time limit exceeded
239. Sliding Window Maximum
 */
class SlidingWindowMaximum {
    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1};
        int k = 3;
        System.out.println(Arrays.toString(obj.maxSlidingWindow(nums1, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1];

        int count = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int windowSize = k + i;
            int max = Integer.MIN_VALUE;
            while (windowSize <= n && j < windowSize) {
                max = Math.max(nums[j], max);
                j++;
            }


            if (windowSize <= nums.length)
                result[count++] = max;
        }

        return result;
    }
}