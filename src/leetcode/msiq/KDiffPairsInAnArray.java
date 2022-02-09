package leetcode.msiq;

import java.util.*;

class KDiffPairsInAnArray {
    public static void main(String[] args) {
        KDiffPairsInAnArray obj = new KDiffPairsInAnArray();
        int[] nums1 = {3, 1, 4, 1, 5};
        int k1 = 2;

        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 1;

        int[] nums3 = {3, 1, 4, 1, 5};
        int k3 = 0;

        int[] nums4 = {1, 2, 4, 4, 3, 3, 0, 9, 2, 3};
        int k4 = 3;

        System.out.println(obj.findPairs(nums1, k1));
        System.out.println(obj.findPairs(nums2, k2));
        System.out.println(obj.findPairs(nums3, k3));
        System.out.println(obj.findPairs(nums4, k4));
    }

    public int findPairsTLE(int[] nums, int k) {
        int count = 0;

        Arrays.sort(nums);

        Set<String> set = new HashSet<>();

        for (int j = 0; j < nums.length; j++) {
            for (int l = j + 1; l < nums.length; l++) {
                set.add(nums[j] + "," + nums[l]);
            }
        }

        System.out.println(set);

        for (String entry : set) {
            String[] values = entry.split(",");
            int value = Math.abs(Integer.parseInt(values[0]) - Integer.parseInt(values[1]));
            if (value == k) {
                count++;
            }
        }

        return count;
    }

    public int findPairs(int[] nums, int k) {
        int count = 0;

        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        System.out.println(hm);

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (k > 0 && hm.containsKey(key + k)) {
                count++;
            } else if (k == 0 && value > 1) {
                count++;
            }
        }

        return count;
    }

    public int findPairsTS(int[] nums, int k) {
        int count = 0;
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int[] uniqueNums = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            uniqueNums[i++] = num;
        }

        System.out.println(Arrays.toString(uniqueNums));

        for (int j = 0; j < uniqueNums.length; j++) {
            for (int l = j + 1; l < uniqueNums.length; l++) {
                int value = Math.abs(uniqueNums[j] - uniqueNums[l]);
                if (value == k) {
                    count++;
                }
            }
        }

        return count;
    }
}