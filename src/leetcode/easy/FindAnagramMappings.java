package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/find-anagram-mappings/
Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Anagram Mappings.
Memory Usage: 37.8 MB, less than 55.05% of Java online submissions for Find Anagram Mappings.
 */

class FindAnagramMappings {
    public static void main(String[] args) {
        FindAnagramMappings obj = new FindAnagramMappings();
        int[] nums1 = {12, 28, 46, 32, 50};
        int[] nums2 = {50, 12, 32, 46, 28};

        obj.anagramMappings(nums1, nums2);
    }

    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            hm.put(nums2[i], hm.getOrDefault(nums2[i], i));
        }

        for (int i = 0; i < nums1.length; i++) {
            Integer position = hm.get(nums1[i]);
            if (position != null) {
                result[i] = position;
            }
        }
        return result;
    }
}