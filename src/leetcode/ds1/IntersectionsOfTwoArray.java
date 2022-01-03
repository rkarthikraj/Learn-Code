package leetcode.ds1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class IntersectionsOfTwoArray {
    public static void main(String[] args) {
        IntersectionsOfTwoArray obj = new IntersectionsOfTwoArray();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println(Arrays.toString(obj.intersect(nums1, nums2)));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> hm = new HashMap<>();

        for (int n : nums1) {
            Integer count = hm.getOrDefault(n, 0);
            hm.put(n, count + 1);
        }

        System.out.println(hm);

        int k = 0;
        for (int n : nums1) {
            Integer count = hm.getOrDefault(n, 0);
            if (count > 0) {
                nums1[k++] = n;
                hm.put(n, count - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}