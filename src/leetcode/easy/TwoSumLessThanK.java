package leetcode.easy;

/*
https://leetcode.com/problems/two-sum-less-than-k/submissions/
Runtime: 3 ms, faster than 20.78% of Java online submissions for Two Sum Less Than K.
Memory Usage: 39 MB, less than 28.37% of Java online submissions for Two Sum Less Than K.
 */
public class TwoSumLessThanK {
    public static int twoSumLessThanK(int[] nums, int k) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                if (sum < k) {
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // int[] nums = {34, 23, 1, 24, 75, 33, 54, 8};
        // int k = 60;

        int[] nums = {10, 20, 30};
        int k = 15;

        System.out.println(twoSumLessThanK(nums, k));
    }
}
