package leetcode.others;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class FindAllLonelyNumbersInTheArray {
    public static void main(String[] args) {
        FindAllLonelyNumbersInTheArray obj = new FindAllLonelyNumbersInTheArray();
        int[] nums = {10, 6, 5, 8, 5};
        System.out.println(obj.findLonely(nums));
    }

    public List<Integer> findLonely(int[] nums) {
        List<Integer> result = new LinkedList<>();
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], numMap.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int value = numMap.get(nums[i]);
            if (value == 1) {
                int previous = nums[i] - 1;
                int next = nums[i] + 1;
                if (!numMap.containsKey(previous) && !numMap.containsKey(next)) {
                    result.add(nums[i]);
                }
            }
        }
        return result;
    }
}