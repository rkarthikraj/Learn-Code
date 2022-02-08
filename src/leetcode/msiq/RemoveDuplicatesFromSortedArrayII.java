package leetcode.msiq;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII obj = new RemoveDuplicatesFromSortedArrayII();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(obj.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return nums.length;
        }

        int memory = nums[0];
        int index = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (memory == nums[i]) {
                counter++;
                if (counter < 3) {
                    nums[index] = nums[i];
                    index++;
                }
            } else if (memory != nums[i]) {
                nums[index] = nums[i];
                memory = nums[i];
                index++;
                counter = 1;
            }
        }

        System.out.println(Arrays.toString(nums));

        return index;
    }

    public int removeDuplicatesWorstSolution(int[] nums) {
        Map<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = tm.get(nums[i]);
            if (value == null) {
                tm.put(nums[i], 1);
            } else if (value < 2) {
                tm.put(nums[i], tm.getOrDefault(nums[i], 0) + 1);
            }
        }

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            while (value > 0) {
                nums[index] = key;
                value--;
                index++;
            }
        }

        return index;
    }
}