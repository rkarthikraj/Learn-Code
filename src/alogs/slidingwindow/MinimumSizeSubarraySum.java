package alogs.slidingwindow;

/*
https://leetcode.com/problems/minimum-size-subarray-sum/
 */
class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();

        System.out.println(obj.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(obj.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(obj.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int index = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        for (int left = 0; left < nums.length; left++) {
            sum += nums[left];

            while (sum >= target) {
                result = Math.min(result, left - index + 1);
                sum -= nums[index++];
            }
        }

        return (result != Integer.MAX_VALUE) ? result : 0;
    }
}