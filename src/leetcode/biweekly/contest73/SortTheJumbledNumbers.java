package leetcode.biweekly.contest73;

import java.util.*;

class SortTheJumbledNumbers {
    public static void main(String[] args) {
        SortTheJumbledNumbers obj = new SortTheJumbledNumbers();
        int[] mapping1 = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums1 = {991, 338, 38};

        int[] mapping2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums2 = {0, 999999999};

        int[] mapping3 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] nums3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(obj.sortJumbled(mapping1, nums1)));
        System.out.println(Arrays.toString(obj.sortJumbled(mapping2, nums2)));
        System.out.println(Arrays.toString(obj.sortJumbled(mapping3, nums3)));
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < mapping.length; i++) {
            hm.put(i, mapping[i]);
        }

        //System.out.println(hm);
        Map<Integer, List<Integer>> tm = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            int number = nums[i];
            StringBuilder sb = new StringBuilder();
            while (number > 0) {
                int rem = number % 10;
                sb.append(hm.get(rem));
                number /= 10;
            }
            int jumbledNum = 0;
            if (!sb.toString().isEmpty()) {
                jumbledNum = Integer.parseInt(sb.reverse().toString());
            } else {
                jumbledNum = hm.get(number);
            }
            List<Integer> values = tm.get(jumbledNum);
            if (values == null) {
                values = new ArrayList<>();
                tm.put(jumbledNum, values);
            }
            values.add(nums[i]);
        }

        //System.out.println(tm);

        int counter = 0;
        for (Map.Entry<Integer, List<Integer>> entry : tm.entrySet()) {
            List<Integer> values = entry.getValue();
            for (int i = 0; i < values.size(); i++) {
                nums[counter] = values.get(i);
                counter++;
            }
        }

        return nums;
    }
}