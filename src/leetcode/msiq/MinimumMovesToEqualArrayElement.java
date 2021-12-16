package leetcode.msiq;

/*
https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
Runtime: 706 ms, faster than 5.05% of Java online submissions for Minimum Moves to Equal Array Elements II.
Memory Usage: 43 MB, less than 9.80% of Java online submissions for Minimum Moves to Equal Array Elements II.
 */

import java.util.Arrays;

class MinimumMovesToEqualArrayElement {
    public static void main(String[] args) {
        MinimumMovesToEqualArrayElement obj = new MinimumMovesToEqualArrayElement();
        int[] nums1 = {1, 10, 9, 2};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {1};
        int[] nums4 = {1, 0, 0, 8, 6};
        int[] nums5 = {203125577, -349566234, 230332704, 48321315, 66379082, 386516853, 50986744, -250908656, -425653504, -212123143};

        System.out.println("Nums1 - 16        :" + obj.minMoves2(nums1));
        System.out.println("Nums2 - 2         :" + obj.minMoves2(nums2));
        System.out.println("Nums3 - 0         :" + obj.minMoves2(nums3));
        System.out.println("Nums4 - 14        :" + obj.minMoves2(nums4));
        System.out.println("Nums5 - 2127271182:" + obj.minMoves2(nums5));
    }

    public int minMoves2(int[] nums) {
        long result = Integer.MAX_VALUE;
        if (nums.length <= 1) {
            return 0;
        }

        int i = 0;
        while (i < nums.length) {
            long sum = 0;
            for (int j = 0; j < nums.length; ++j) {
                sum += Math.abs(nums[i] - nums[j]);
            }

            result = Math.min(sum, result);
            i++;
        }
        return (int) result;
    }

    public int minMoves2Optimized(int[] nums) {
        int l = 0, r = nums.length - 1, sum = 0;
        Arrays.sort(nums);
        while (l < r) {
            sum += nums[r] - nums[l];
            l++;
            r--;
        }
        return sum;
    }
}