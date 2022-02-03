package leetcode.others;

import java.util.HashMap;
import java.util.Map;

class FourSumII {
    public static void main(String[] args) {
        FourSumII obj = new FourSumII();
        int[] nums1 = {1, 2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0, 2};
        System.out.println(obj.fourSumCount(nums1, nums2, nums3, nums4));
    }

    public int fourSumCountBruteForce(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;

        for (int num1 : nums1)
            for (int num2 : nums2)
                for (int num3 : nums3)
                    for (int num4 : nums4)
                        if (num1 + num2 + num3 + num4 == 0)
                            count++;

        return count;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                hm.put(num3 + num4, hm.getOrDefault(num3 + num4, 0) + 1);
            }
        }

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                count += hm.getOrDefault(-(num1 + num2), 0);
            }
        }

        return count;
    }
}