package leetcode.ds1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSumII {
    public static void main(String[] args) {
        TwoSumII obj = new TwoSumII();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // int[] nums = {2, 3, 4};
        // int target = 6;

        System.out.println(Arrays.toString(obj.twoSum(nums, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> hm = new HashMap<>();

        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}

/*
if (numbers[mid] == target) {
    result[0] = target;
    System.out.println(hm);
    return result;
}
 */